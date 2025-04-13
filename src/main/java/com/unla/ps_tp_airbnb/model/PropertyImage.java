package com.unla.ps_tp_airbnb.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PropertyImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String imageUrl;
	private LocalDate uploadedAt;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "property_id")
	private Property property;
	
	public PropertyImage() {
		
	}

	public PropertyImage(Long id, String imageUrl, LocalDate uploadedAt, Property property) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.uploadedAt = uploadedAt;
		this.property = property;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public LocalDate getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(LocalDate uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return "PropertyImage [id=" + id + ", imageUrl=" + imageUrl + ", uploadedAt=" + uploadedAt + ", property="
				+ property + "]";
	}

}