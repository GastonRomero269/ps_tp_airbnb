package com.unla.ps_tp_airbnb.dto;

import java.time.LocalDateTime;

public class ReviewDTO {
	private Long id;
	private Long reservationId;
	private int rating;
	private String comment;
	private LocalDateTime createdAt;

	public ReviewDTO(Long id, Long reservationId, int rating, String comment, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.reservationId = reservationId;
		this.rating = rating;
		this.comment = comment;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
