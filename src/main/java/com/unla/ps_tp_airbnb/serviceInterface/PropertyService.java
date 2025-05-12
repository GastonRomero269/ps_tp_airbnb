package com.unla.ps_tp_airbnb.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.unla.ps_tp_airbnb.model.Property;

public interface PropertyService {
	List<Property> findAll();

	Optional<Property> findById(Long id);

	Property save(Property property);

	void delete(Long id);

	List<Property> findByLocationContainingIgnoreCase(String query);

	List<Property> findByRatingGreaterThan(double rating);

	List<Property> findByTitleContainingIgnoreCase(String title);

	List<Property> findByHostId(Long id);

	List<Property> findByFilters(String type, Integer maxGuests, Double priceMin, Double priceMax);
}
