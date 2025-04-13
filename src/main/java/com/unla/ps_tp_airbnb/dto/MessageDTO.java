package com.unla.ps_tp_airbnb.dto;

import java.time.LocalDateTime;

public class MessageDTO {
	private Long id;
	private Long senderId;
	private Long receiverId;
	private Long propertyId;
	private String messageText;
	private LocalDateTime timestamp;

	public MessageDTO(Long id, Long senderId, Long receiverId, String content, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.messageText = content;
		this.timestamp = timestamp;
	}

	public MessageDTO() {

	}

	public Long getId() {
		return id;
	}

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
