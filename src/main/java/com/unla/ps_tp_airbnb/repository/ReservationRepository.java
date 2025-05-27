package com.unla.ps_tp_airbnb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unla.ps_tp_airbnb.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findByGuestId(Long guestId);

	@Query("SELECT r FROM Reservation r WHERE r.property.host.id = :hostId")
	List<Reservation> findByHostId(@Param("hostId") Long hostId);

}