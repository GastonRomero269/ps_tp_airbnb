package com.unla.ps_tp_airbnb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.ps_tp_airbnb.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	List<Review> findByPropertyId(Long id);
}