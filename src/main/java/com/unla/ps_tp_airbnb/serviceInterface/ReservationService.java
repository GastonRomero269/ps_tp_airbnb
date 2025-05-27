package com.unla.ps_tp_airbnb.serviceInterface;

import java.util.List;

import com.unla.ps_tp_airbnb.model.Reservation;

public interface ReservationService {
	List<Reservation> findAll();

	Reservation findById(Long id);

	Reservation save(Reservation reservation);

	void delete(Long id);

	List<Reservation> findByGuestId(Long guestId);

	List<Reservation> findByHostId(Long hostId);
}
