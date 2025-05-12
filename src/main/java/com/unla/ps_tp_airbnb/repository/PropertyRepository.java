package com.unla.ps_tp_airbnb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.ps_tp_airbnb.model.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
	List<Property> findByLocationContainingIgnoreCase(String location);

	List<Property> findByRatingGreaterThan(double rating);

	List<Property> findByTitleContainingIgnoreCase(String title);

	List<Property> findByHostId(Long id);

	List<Property> findByTitleContainingIgnoreCaseAndMaxGuestsLessThanEqualAndPricePerNightBetween(String title,
			Integer maxGuests, Double priceMin, Double priceMax);
}