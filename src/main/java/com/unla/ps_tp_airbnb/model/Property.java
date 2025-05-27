package com.unla.ps_tp_airbnb.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String location;
	private Double pricePerNight;
	private int maxGuests;
	private LocalDate createdAt;
	private double rating;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "host_id")
	private User host;

	@OneToMany(mappedBy = "property", fetch = FetchType.EAGER)
	private List<PropertyImage> images;

	public Property() {

	}

	public Property(Long id, String title, String description, String location, Double pricePerNight, int maxGuests,
			LocalDate createdAt, User host, List<PropertyImage> images, double rating) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.pricePerNight = pricePerNight;
		this.maxGuests = maxGuests;
		this.createdAt = createdAt;
		this.host = host;
		this.images = images;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(Double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public int getMaxGuests() {
		return maxGuests;
	}

	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<PropertyImage> getImages() {
		return images;
	}

	public void setImages(List<PropertyImage> images) {
		this.images = images;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", pricePerNight=" + pricePerNight + ", maxGuests=" + maxGuests + ", createdAt=" + createdAt
				+ ", rating=" + rating + ", host=" + host + ", images=" + images + "]";
	}

}