package com.unla.ps_tp_airbnb.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unla.ps_tp_airbnb.model.Property;
import com.unla.ps_tp_airbnb.model.Reservation;
import com.unla.ps_tp_airbnb.model.TypeGuests;
import com.unla.ps_tp_airbnb.model.User;
import com.unla.ps_tp_airbnb.serviceInterface.PropertyService;
import com.unla.ps_tp_airbnb.serviceInterface.ReservationService;
import com.unla.ps_tp_airbnb.serviceInterface.TypeGuestsService;
import com.unla.ps_tp_airbnb.serviceInterface.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private UserService userService;

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private TypeGuestsService typeGuestsService;

	@GetMapping("/reservations")
	public String reservations(@RequestParam(required = false) String status, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		List<Reservation> reservations;

		if (userService.findById(userId).get().getRole() == User.Role.GUEST) {
			reservations = reservationService.findByGuestId(userId);
		} else {
			reservations = reservationService.findByHostId(userId);
		}

		if (status != null) {
			switch (status.toUpperCase()) {
			case "PENDING":
				reservations = reservations.stream()
						.filter(reservation -> reservation.getStatus() == Reservation.Status.PENDING)
						.collect(Collectors.toList());
				break;
			case "CONFIRM":
				reservations = reservations.stream()
						.filter(reservation -> reservation.getStatus() == Reservation.Status.CONFIRMED)
						.collect(Collectors.toList());
				break;
			case "CANCELLED":
				reservations = reservations.stream()
						.filter(reservation -> reservation.getStatus() == Reservation.Status.CANCELLED)
						.collect(Collectors.toList());
				break;
			case "ACTIVE":
				reservations = reservations.stream()
						.filter(reservation -> reservation.getEndDate().isAfter(LocalDate.now()))
						.collect(Collectors.toList());
				break;
			case "INACTIVE":
				reservations = reservations.stream()
						.filter(reservation -> reservation.getEndDate().isBefore(LocalDate.now())
								|| reservation.getEndDate().isEqual(LocalDate.now()))
						.collect(Collectors.toList());
				break;
			default:
				break;
			}
		}

		model.addAttribute("reservations", reservations);
		return "reservation/reservations";
	}

	@GetMapping("/update{id}")
	public String updateReservation(@PathVariable Long id, HttpSession session, Model model) {
		Reservation reservation = reservationService.findById(id);
		reservation.setStatus(Reservation.Status.CONFIRMED);
		reservationService.save(reservation);
		return "redirect:/reservation/reservations";
	}

	@GetMapping("/{id}")
	public String reservationsDetails(@PathVariable Long id, HttpSession session, Model model) {
		Reservation reservation = reservationService.findById(id);
		model.addAttribute("reservation", reservation);
		return "reservation/reservations-detail";
	}

	@GetMapping("/create-reservation")
	public String createReservation(HttpSession session, Model model, @RequestParam("propertyId") Long propertyID) {
		if ((Long) session.getAttribute("userId") == null) {
			return "redirect:/login";
		}

		Property property = (propertyService.findById(propertyID)).orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));
		model.addAttribute("property", property);
		model.addAttribute("maxGuests", property.getMaxGuests());
		List<Reservation> reservations = reservationService.findByHostId(property.getHost().getId());

		List<LocalDate> bookedDates = new ArrayList<>();
		for (Reservation reservation : reservations) {
			if (reservation.getProperty().getId().equals(property.getId())) {
				LocalDate date = reservation.getStartDate();
				while (!date.isAfter(reservation.getEndDate())) {
					bookedDates.add(date);
					date = date.plusDays(1);
				}
			}
		}

		List<String> bookedDatesStr = bookedDates.stream().map(LocalDate::toString).collect(Collectors.toList());
		model.addAttribute("bookedDates", bookedDatesStr);

		return "reservation/create-reservation";
	}

	@PostMapping("/confirm")
	public String confirmReservation(@RequestParam("propertyId") Long propertyId,
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
		    @RequestParam(name="max-guests-limit", required=false, defaultValue="0") int maxGuests,
		    @RequestParam(name="adults", required=false, defaultValue="0") int cantityAdults,
		    @RequestParam(name="childs", required=false, defaultValue="0") int cantityChilds,
		    @RequestParam(name="babys",  required=false, defaultValue="0") int cantityBabys,
		    @RequestParam(name="pets",   required=false, defaultValue="0") int cantityPets,
			HttpSession session, Model model) {

		Optional<User> guestOpt = userService.findById((Long) session.getAttribute("userId"));
		Optional<Property> propertyOpt = propertyService.findById(propertyId);
		
		if (cantityAdults == 0) {
			return "redirect:/reservation/create-reservation?propertyId=" + propertyId + "&error=noAdults";
		}

		if (guestOpt.isPresent() && propertyOpt.isPresent()) {
			Property property = propertyOpt.get();

			List<Reservation> existingReservations = reservationService.findByHostId(property.getHost().getId());

			boolean isAvailable = existingReservations.stream().noneMatch(reservation -> {
				return reservation.getProperty().getId().equals(propertyId)
						&& !(endDate.isBefore(reservation.getStartDate())
								|| startDate.isAfter(reservation.getEndDate()));
			});

			if (!isAvailable) {
				return "redirect:/reservation/create-reservation?propertyId=" + propertyId + "&error=notAvailable";
			}

			long days = ChronoUnit.DAYS.between(startDate, endDate);
			double totalPrice = days * property.getPricePerNight();

			Reservation reservation = new Reservation();
			reservation.setGuest(guestOpt.get());
			reservation.setProperty(property);
			reservation.setStartDate(startDate);
			reservation.setEndDate(endDate);
			reservation.setCreatedAt(LocalDate.now());
			reservation.setTotalPrice(totalPrice);
			reservation.setStatus(Reservation.Status.PENDING);
			reservation.setCantityGuests(cantityAdults + cantityChilds + cantityBabys + cantityPets);

			TypeGuests typeGuests = new TypeGuests();
			typeGuests.setAdults(cantityAdults);
			typeGuests.setChilds(cantityChilds);
			typeGuests.setBabys(cantityBabys);
			typeGuests.setPets(cantityPets);
			typeGuestsService.save(typeGuests);

			reservation.setTypeGuests(typeGuests);
			reservationService.save(reservation);
			return "redirect:/reservation/reservations";
		}

		return "redirect:/";
	}
	
	@GetMapping("/modify-reservation")
	public String modifyReservation(
	        HttpSession session,
	        Model model,
	        @RequestParam("propertyId") Long propertyID,
	        @RequestParam("reservationId") Long reservationID) {

	    if (session.getAttribute("userId") == null) {
	        return "redirect:/login";
	    }

	    Property property = propertyService.findById(propertyID)
	        .orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));

	    Reservation reservation = reservationService.findById(reservationID);
	    if (reservation == null || !reservation.getProperty().getId().equals(propertyID)) {
	        throw new RuntimeException("Reserva no válida para esta propiedad");
	    }

	    List<Reservation> reservations = reservationService.findByHostId(property.getHost().getId());
	    List<LocalDate> bookedDates = new ArrayList<>();
	    for (Reservation res : reservations) {
	        if (res.getProperty().getId().equals(propertyID)) {
	            LocalDate date = res.getStartDate();
	            while (!date.isAfter(res.getEndDate())) {
	                bookedDates.add(date);
	                date = date.plusDays(1);
	            }
	        }
	    }

	    model.addAttribute("property", property);
	    model.addAttribute("reservation", reservation);
	    model.addAttribute("bookedDates", bookedDates);

	    return "reservation/modify-reservation";
	}

	
	@PostMapping("/confirm-modify-reservation")
	public String confirmModifyReservation(@RequestParam("reservationId") Long reservationId, @RequestParam("propertyId") Long propertyId,
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
			@RequestParam(name = "max-guests-limit", defaultValue = "0") int cantityGuests,
			@RequestParam(name = "adults", defaultValue = "0") int cantityAdults,
			@RequestParam(name = "childs", defaultValue = "0") int cantityChilds,
			@RequestParam(name = "babys", defaultValue = "0") int cantityBabys,
			@RequestParam(name = "pets", defaultValue = "0") int cantityPets, HttpSession session) {
		
		if (cantityAdults == 0) {
			return "redirect:/reservation/create-reservation?propertyId=" + propertyId + "&error=noAdults";
		}

		Optional<User> guestOpt = userService.findById((Long) session.getAttribute("userId"));
		Optional<Property> propertyOpt = propertyService.findById(propertyId);

		if (guestOpt.isPresent() && propertyOpt.isPresent()) {
			Property property = propertyOpt.get();

			if (!endDate.isAfter(startDate)) {
				return "redirect:/reservation/create-reservation?propertyId=" + propertyId + "&error=invalidDates";
			}

			List<Reservation> existingReservations = reservationService.findByHostId(property.getHost().getId());

			boolean isAvailable = existingReservations.stream().noneMatch(reservation -> {
				return reservation.getProperty().getId().equals(propertyId)
						&& !(endDate.isBefore(reservation.getStartDate())
								|| startDate.isAfter(reservation.getEndDate()));
			});

			if (!isAvailable) {
				return "redirect:/reservation/create-reservation?propertyId=" + propertyId + "&error=notAvailable";
			}

			long days = ChronoUnit.DAYS.between(startDate, endDate);
			double totalPrice = days * property.getPricePerNight();

			Reservation reservation = reservationService.findById(reservationId);
			reservation.setGuest(guestOpt.get());
			reservation.setProperty(property);
			reservation.setStartDate(startDate);
			reservation.setEndDate(endDate);
			reservation.setCreatedAt(LocalDate.now());
			reservation.setTotalPrice(totalPrice);
			reservation.setStatus(Reservation.Status.PENDING);
			reservation.setCantityGuests(cantityGuests);

			TypeGuests typeGuests = new TypeGuests();
			typeGuests.setAdults(cantityAdults);
			typeGuests.setChilds(cantityChilds);
			typeGuests.setBabys(cantityBabys);
			typeGuests.setPets(cantityPets);
			typeGuestsService.save(typeGuests);

			reservation.setTypeGuests(typeGuests);
			reservationService.save(reservation);
			return "redirect:/reservation/reservations";
		}

		return "redirect:/";
	}

	@GetMapping("/cancell{id}")
	public String cancellReservation(@PathVariable Long id, HttpSession session, Model model) {
		Reservation reservation = reservationService.findById(id);
		reservation.setStatus(Reservation.Status.CANCELLED);
		reservationService.save(reservation);
		return "redirect:/reservation/reservations";
	}
}
