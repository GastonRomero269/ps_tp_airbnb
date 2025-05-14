package com.unla.ps_tp_airbnb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.unla.ps_tp_airbnb.model.User;
import com.unla.ps_tp_airbnb.serviceInterface.UserService;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private UserService userService;

    @ModelAttribute
    public void addUserToModel(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        
        if (userId != null) {
        	User user = userService.findById(userId).get();
        	model.addAttribute("currentUser", user);
        	
            if(user.getRole() == User.Role.HOST) {
            	model.addAttribute("isHost", true);
            } else {
            	model.addAttribute("isHost", false);
            }
        }
    }
}

