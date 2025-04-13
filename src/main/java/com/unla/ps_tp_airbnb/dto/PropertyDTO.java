package com.unla.ps_tp_airbnb.dto;

public class PropertyDTO {

	private Long id;
	private String title;
	private String description;
	private int maxGuests;
	private double pricePerNight;
	private String location;
	private Double rating = 0.0;

	// Constructor
	public PropertyDTO(Long id, String title, String location, double rating) {
		this.id = id;
		this.title = title;
		this.location = location;
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxGuests() {
		return maxGuests;
	}

	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	// Getters y Setters
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
