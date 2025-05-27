package com.unla.ps_tp_airbnb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.ps_tp_airbnb.model.Review;
import com.unla.ps_tp_airbnb.repository.ReviewRepository;
import com.unla.ps_tp_airbnb.serviceInterface.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	public List<Review> findAll() {
		return reviewRepository.findAll();
	}

	public Review findById(Long id) {
		return reviewRepository.findById(id).orElse(null);
	}

	public Review save(Review review) {
		return reviewRepository.save(review);
	}

	public void delete(Long id) {
		reviewRepository.deleteById(id);
	}

	@Override
	public List<Review> findByPropertyId(Long id) {
		return reviewRepository.findByPropertyId(id);
	}

	public double calculateAverageRatingByPropertyId(Long propertyId) {
		List<Review> reviews = reviewRepository.findByPropertyId(propertyId);

		if (reviews.isEmpty()) {
			return 0.0;
		}

		double sum = reviews.stream().mapToDouble(Review::getRating).sum();
		return sum / reviews.size();
	}

}
