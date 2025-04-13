package com.unla.ps_tp_airbnb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.ps_tp_airbnb.model.PropertyImage;
import com.unla.ps_tp_airbnb.serviceInterface.PropertyImageService;

@Controller
@RequestMapping("/property-images")
public class PropertyImageController {

	@Autowired
	private PropertyImageService propertyImageService;

	@GetMapping
	public String all(Model model) {
		model.addAttribute("propertyImages", propertyImageService.findAll());
		return "property-images";
	}

	@GetMapping("/new")
	public String newImageForm(Model model) {
		model.addAttribute("propertyImage", new PropertyImage());
		return "property-image-form";
	}

	@PostMapping
	public String create(@ModelAttribute PropertyImage propertyImage) {
		propertyImageService.save(propertyImage);
		return "redirect:/property-images";
	}
}
