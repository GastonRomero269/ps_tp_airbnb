package com.unla.ps_tp_airbnb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.ps_tp_airbnb.model.User;
import com.unla.ps_tp_airbnb.serviceInterface.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String all(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}

	@GetMapping("/new")
	public String newUserForm(Model model) {
		model.addAttribute("user", new User());
		return "user-form";
	}

	@PostMapping
	public String create(@ModelAttribute User user) {
		userService.save(user);
		return "redirect:/users";
	}
}