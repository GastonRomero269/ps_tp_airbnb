package com.unla.ps_tp_airbnb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.ps_tp_airbnb.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
	List<Message> findByReceiverIdOrSenderId(Long receiverId, Long senderId);
}