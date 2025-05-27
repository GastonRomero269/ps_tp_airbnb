package com.unla.ps_tp_airbnb.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "property_id")
	private Property property;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "guest_id")
	private User guest;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_guest_id", nullable = false)
	private TypeGuests typeGuests;

	private int cantityGuests;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double totalPrice;

	@Enumerated(EnumType.STRING)
	private Status status;
	private LocalDate createdAt;

	private String methodPay;

	public enum Status {
		PENDING, CONFIRMED, CANCELLED
	}

	public Reservation() {

	}

	public Reservation(Long id, Property property, User guest, LocalDate startDate, LocalDate endDate,
			Double totalPrice, Status status, LocalDate createdAt, int cantityGuests) {
		super();
		this.id = id;
		this.property = property;
		this.guest = guest;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.status = status;
		this.createdAt = createdAt;
		this.cantityGuests = cantityGuests;
	}

	public Reservation(Long id, Property property, User guest, TypeGuests typeGuests, int cantityGuests,
			LocalDate startDate, LocalDate endDate, Double totalPrice, Status status, LocalDate createdAt,
			String methodPay) {
		super();
		this.id = id;
		this.property = property;
		this.guest = guest;
		this.typeGuests = typeGuests;
		this.cantityGuests = cantityGuests;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.status = status;
		this.createdAt = createdAt;
		this.methodPay = methodPay;
	}

	public String getMethodPay() {
		return methodPay;
	}

	public void setMethodPay(String methodPay) {
		this.methodPay = methodPay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public User getGuest() {
		return guest;
	}

	public void setGuest(User guest) {
		this.guest = guest;
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

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public int getCantityGuests() {
		return cantityGuests;
	}

	public void setCantityGuests(int cantityGuests) {
		this.cantityGuests = cantityGuests;
	}

	public TypeGuests getTypeGuests() {
		return typeGuests;
	}

	public void setTypeGuests(TypeGuests typeGuests) {
		this.typeGuests = typeGuests;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDate.now();
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", property=" + property + ", guest=" + guest + ", cantityGuests="
				+ cantityGuests + ", startDate=" + startDate + ", endDate=" + endDate + ", totalPrice=" + totalPrice
				+ ", status=" + status + ", createdAt=" + createdAt + "]";
	}

}