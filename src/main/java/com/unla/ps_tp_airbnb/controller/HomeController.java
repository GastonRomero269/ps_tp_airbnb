package com.unla.ps_tp_airbnb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.unla.ps_tp_airbnb.model.Property;
import com.unla.ps_tp_airbnb.serviceInterface.PropertyService;

@Controller
public class HomeController {

	@Autowired
    private PropertyService propertyService;

    @GetMapping("/")
    public String index(Model model) {
        List<Property> properties = propertyService.findByRatingGreaterThan(4.4);
        model.addAttribute("properties", properties);
        return "index";
    }
    
}


