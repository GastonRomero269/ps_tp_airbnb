package com.unla.ps_tp_airbnb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.ps_tp_airbnb.model.Reservation;
import com.unla.ps_tp_airbnb.repository.ReservationRepository;
import com.unla.ps_tp_airbnb.serviceInterface.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	public Reservation findById(Long id) {
		return reservationRepository.findById(id).orElse(null);
	}

	public Reservation save(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	public void delete(Long id) {
		reservationRepository.deleteById(id);
	}

	@Override
	public List<Reservation> findByGuestId(Long guestId) {
		return reservationRepository.findByGuestId(guestId);
	}

	@Override
	public List<Reservation> findByHostId(Long hostId) {
		return reservationRepository.findByHostId(hostId);
	}
}
