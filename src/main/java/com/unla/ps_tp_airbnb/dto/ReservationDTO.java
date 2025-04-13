package com.unla.ps_tp_airbnb.dto;

import java.time.LocalDate;

public class ReservationDTO {
	private Long id;
	private Long guestId;
	private Long propertyId;
	private LocalDate startDate;
	private LocalDate endDate;
	private double totalPrice;

	public ReservationDTO(Long id, Long guestId, Long propertyId, LocalDate startDate, LocalDate endDate,
			double totalPrice) {
		super();
		this.id = id;
		this.guestId = guestId;
		this.propertyId = propertyId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGuestId() {
		return guestId;
	}

	public void setGuestId(Long guestId) {
		this.guestId = guestId;
	}

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
