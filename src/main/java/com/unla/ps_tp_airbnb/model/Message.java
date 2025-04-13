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
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sender_id")
	private User sender;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "receiver_id")
	private User receiver;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "property_id")
	private Property property;

	private String messageText;
	private LocalDate timestamp;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "next_message_id")
	private Message nextMessage;

	public Message() {

	}

	public Message(User sender, User receiver, Property property, String messageText, LocalDate timestamp) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.property = property;
		this.messageText = messageText;
		this.timestamp = timestamp;
	}

	public Message(Long id, User sender, User receiver, Property property, String messageText, LocalDate timestamp) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.property = property;
		this.messageText = messageText;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public Property getProperty() {
		return property;
	}

	public Message getNextMessage() {
		return nextMessage;
	}

	public void setNextMessage(Message previousMessage) {
		this.nextMessage = previousMessage;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", property=" + property
				+ ", messageText=" + messageText + ", timestamp=" + timestamp + "]";
	}

}