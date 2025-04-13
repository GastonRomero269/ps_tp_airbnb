package com.unla.ps_tp_airbnb.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unla.ps_tp_airbnb.dto.MessageDTO;
import com.unla.ps_tp_airbnb.model.Message;
import com.unla.ps_tp_airbnb.model.Property;
import com.unla.ps_tp_airbnb.model.User;
import com.unla.ps_tp_airbnb.serviceInterface.MessageService;
import com.unla.ps_tp_airbnb.serviceInterface.PropertyService;
import com.unla.ps_tp_airbnb.serviceInterface.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@Autowired
	private UserService userService;

	@Autowired
	private PropertyService propertyService;

	@GetMapping("/messages")
	public String messages(@RequestParam(value = "search", required = false) String search, HttpSession session,
			Model model) {
		Long id = (Long) session.getAttribute("userId");
		List<Message> messages = messageService.findByReceiverIdOrSenderId(id, id);
		List<List<Message>> messageThreads = new ArrayList<>();

		Map<Long, Message> messageMap = new HashMap<>();
		for (Message message : messages) {
			messageMap.put(message.getId(), message);
		}

		Set<Long> processedMessages = new HashSet<>();
		for (Message message : messages) {
			if (!processedMessages.contains(message.getId())) {
				List<Message> thread = new ArrayList<>();
				Message currentMessage = message;

				while (currentMessage != null && !processedMessages.contains(currentMessage.getId())) {
					thread.add(currentMessage);
					processedMessages.add(currentMessage.getId());
					currentMessage = currentMessage.getNextMessage();
				}

				if (search == null || thread.isEmpty()
						|| thread.get(0).getSender().getName().toLowerCase().contains(search.toLowerCase())) {
					messageThreads.add(thread);
				}

			}
		}

		model.addAttribute("messageThreads", messageThreads);
		model.addAttribute("search", search);
		return "message/messages";
	}

	@GetMapping("/start-conversation/{id}")
	public String startConversation(@PathVariable Long id, HttpSession session, Model model) {
		Property property = propertyService.findById(id).get();

		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setPropertyId(property.getId());
		messageDTO.setSenderId((Long) session.getAttribute("userId"));
		messageDTO.setReceiverId(property.getHost().getId());
		model.addAttribute("reply", messageDTO);
		model.addAttribute("host", property.getHost());
		return "message/start-conversation";
	}

	@PostMapping("/send-start-conversation")
	public String sendStartConversation(@RequestParam Long senderId, @RequestParam Long receiverId,
			@RequestParam Long propertyId, @RequestParam String messageText) {
		User sender = userService.findById(senderId).orElseThrow();
		User receiver = userService.findById(receiverId).orElseThrow();
		Property property = propertyService.findById(propertyId).orElseThrow();

		Message message = new Message();
		message.setSender(sender);
		message.setReceiver(receiver);
		message.setProperty(property);
		message.setMessageText(messageText);
		message.setTimestamp(LocalDate.now());

		messageService.save(message);

		return "redirect:/message/messages";
	}

	@GetMapping("/reply/{id}")
	public String replyForm(@PathVariable Long id, Model model) {
		Optional<Message> optionalMessage = messageService.findById(id);

		if (optionalMessage.isPresent()) {
			Message original = optionalMessage.get();
			original.getProperty();
			original.getReceiver();
			original.getSender();
			model.addAttribute("original", original);
			model.addAttribute("originalId", original.getId());
			MessageDTO messageDTO = new MessageDTO();
			messageDTO.setId(id);
			messageDTO.setPropertyId(original.getProperty().getId());
			messageDTO.setSenderId(original.getSender().getId());
			messageDTO.setReceiverId(original.getReceiver().getId());
			model.addAttribute("reply", messageDTO);

			return "message/reply";
		}

		return "redirect:/message/messages";
	}

	@PostMapping("/reply")
	public String sendReply(HttpSession session, @ModelAttribute Message message,
			@RequestParam("originalId") Long originalId) {
		messageService.save(message);

		Message firstMessage = messageService.findById(originalId).get();
		Message secondMessage = messageService.findById(message.getId()).orElse(null);

		System.out.println("primer mensaje" + originalId);
		System.out.println("ultimo mensaje" + message.getId());

		if (firstMessage != null) {
			firstMessage.setNextMessage(secondMessage);
			messageService.save(firstMessage);

			secondMessage.setSender(firstMessage.getReceiver());
			secondMessage.setReceiver(firstMessage.getSender());
			secondMessage.setProperty(firstMessage.getProperty());
			secondMessage.setTimestamp(LocalDate.now());
			messageService.save(secondMessage);
		}

		return "redirect:/message/messages";
	}

}
