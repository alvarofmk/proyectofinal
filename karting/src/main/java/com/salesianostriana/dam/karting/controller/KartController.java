package com.salesianostriana.dam.karting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.karting.model.Kart;
import com.salesianostriana.dam.karting.service.KartService;

@Controller
public class KartController {
	
	@Autowired
	private KartService kartservice;
	
	@GetMapping("/karts")
	public String kartsAdmin(Model model) {
		Kart kart = new Kart();
		model.addAttribute("karts", kartservice.findAll());
		model.addAttribute("kart", kart);
		return "karts";
	}
	
	@GetMapping("/karts/update/{id}")
	public String actualizarKart(@PathVariable("id") long id,  Model model) {
		model.addAttribute("karts", kartservice.findAll());
		model.addAttribute("kart", kartservice.findById(id));
		return "karts";
	}
	
	@PostMapping("/karts/edicion")
	public String guardarKart(@ModelAttribute("kart") Kart kart,  Model model) {
		kartservice.edit(kart);
		return "redirect:/karts";
	}

}
