package com.unla.ps_tp_airbnb.serviceInterface;

import java.util.List;

import com.unla.ps_tp_airbnb.model.Review;

public interface ReviewService {
	List<Review> findAll();

	Review findById(Long id);

	Review save(Review review);

	void delete(Long id);

	List<Review> findByPropertyId(Long id);

	public double calculateAverageRatingByPropertyId(Long propertyId);
}
