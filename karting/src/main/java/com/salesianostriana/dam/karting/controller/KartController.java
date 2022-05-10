package com.salesianostriana.dam.karting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.karting.model.Kart;
import com.salesianostriana.dam.karting.service.KartService;

@Controller
public class KartController {
	
	@Autowired
	private KartService kartservice;
	
	@GetMapping("/karts")
	public String kartsAdmin(Model model) {
		Kart nuevoKart = new Kart();
		model.addAttribute("karts", kartservice.findAll());
		model.addAttribute("nuevoKart", nuevoKart);
		return "karts";
	}
	
	@PostMapping("/addkart")
	public String addKart(@ModelAttribute("nuevoKart") Kart nuevoKart,  Model model) {
		kartservice.save(nuevoKart);
		return "redirect:/karts";
	}

}
