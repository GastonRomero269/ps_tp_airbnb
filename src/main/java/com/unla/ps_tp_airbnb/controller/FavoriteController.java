package com.unla.ps_tp_airbnb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.ps_tp_airbnb.model.Property;
import com.unla.ps_tp_airbnb.serviceInterface.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/users/favorites")
public class FavoriteController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listFavorites(HttpSession session, Model model) {
    	Long id = (Long) session.getAttribute("userId");
    	model.addAttribute("properties", userService.getFavorites(id));
        return "users/favorites";
    }
}
