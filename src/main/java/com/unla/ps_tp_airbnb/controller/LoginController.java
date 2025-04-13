package com.unla.ps_tp_airbnb.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unla.ps_tp_airbnb.model.User;
import com.unla.ps_tp_airbnb.serviceInterface.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Optional<User> userOpt = userService.findByEmailAndPasswordHash(email, password); 

        if (userOpt.isPresent()) {
            System.out.println("Usuario autenticado: " + userOpt.get().getName());
            session.setAttribute("userId", userOpt.get().getId());
            return "redirect:/"; 
        } else {
            model.addAttribute("error", true);
            return "login/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); 
        return "redirect:/";
    }

    
    @GetMapping("/register")
    public String registerForm() {
        return "login/register"; 
    }

    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Optional<User> existingUser = userService.findByEmail(email);
        
        if (existingUser.isPresent()) {
            model.addAttribute("error", "Ya existe una cuenta con ese correo");
            return "login/register";
        }

        User newUser = new User();
        newUser.setName(name);
        newUser.setCreatedAt(LocalDate.now());
        newUser.setEmail(email);
        newUser.setPasswordHash(password); 
        newUser.setRole(User.Role.GUEST); 

        userService.save(newUser);
        session.setAttribute("userId", newUser.getId());
        return "redirect:/"; 
    }
    
}
