package com.unla.ps_tp_airbnb.dto;

public class PropertyImageDTO {
	private Long id;
	private Long propertyId;
	private String imageUrl;

	public PropertyImageDTO(Long id, Long propertyId, String imageUrl) {
		super();
		this.id = id;
		this.propertyId = propertyId;
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
