package com.unla.ps_tp_airbnb.controller;

import java.time.LocalDate;

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
import com.unla.ps_tp_airbnb.model.Review;
import com.unla.ps_tp_airbnb.model.User;
import com.unla.ps_tp_airbnb.serviceInterface.PropertyService;
import com.unla.ps_tp_airbnb.serviceInterface.ReviewService;
import com.unla.ps_tp_airbnb.serviceInterface.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private UserService userService;

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/create-review/{propertyId}")
	public String createReview(@PathVariable Long propertyId, Model model, HttpSession session) {
		Property property = propertyService.findById(propertyId)
				.orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));

		Long guestId = (Long) session.getAttribute("userId");
		User guest = userService.findById(guestId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		model.addAttribute("property", property);
		model.addAttribute("guest", guest);
		model.addAttribute("guestId", guestId);

		return "review/create-review";
	}

	@PostMapping("/submit")
	public String submitReview(
			@RequestParam("createdAt") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createdAt,
			@RequestParam("rating") double rating, @RequestParam("comment") String comment,
			@RequestParam("guestId") Long guestId, @RequestParam("propertyId") Long propertyId) {
		Review review = new Review();
		review.setCreatedAt(createdAt);
		review.setRating(rating);
		review.setComment(comment);

		User guest = userService.findById(guestId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		Property property = propertyService.findById(propertyId)
				.orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));

		review.setGuest(guest);
		review.setProperty(property);

		reviewService.save(review);

		double avgRating = reviewService.calculateAverageRatingByPropertyId(propertyId);
		property.setRating(avgRating);
		propertyService.save(property);

		return "redirect:/";
	}
}