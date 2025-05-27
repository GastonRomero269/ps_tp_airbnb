package com.unla.ps_tp_airbnb.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.unla.ps_tp_airbnb.model.Message;

public interface MessageService {
	List<Message> findAll();

	Optional<Message> findById(Long id);

	Message save(Message message);

	void deleteById(Long id);

	List<Message> findByReceiverIdOrSenderId(Long receiverId, Long senderId);
}
