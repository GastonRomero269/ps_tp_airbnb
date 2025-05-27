package com.unla.ps_tp_airbnb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.ps_tp_airbnb.model.Message;
import com.unla.ps_tp_airbnb.repository.MessageRepository;
import com.unla.ps_tp_airbnb.serviceInterface.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private final MessageRepository messageRepository;

	public MessageServiceImpl(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public List<Message> findAll() {
		return messageRepository.findAll();
	}

	public Optional<Message> findById(Long id) {
		return messageRepository.findById(id);
	}

	public Message save(Message message) {
		return messageRepository.save(message);
	}

	public void deleteById(Long id) {
		messageRepository.deleteById(id);
	}

	@Override
	public List<Message> findByReceiverIdOrSenderId(Long receiverId, Long senderId) {
		return messageRepository.findByReceiverIdOrSenderId(receiverId, senderId);
	}

}
