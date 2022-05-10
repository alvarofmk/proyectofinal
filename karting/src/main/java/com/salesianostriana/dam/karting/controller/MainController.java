package com.salesianostriana.dam.karting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.karting.service.KartService;
import com.salesianostriana.dam.karting.service.PilotoService;

@Controller
public class MainController {
	
	@Autowired
	private KartService kartservice;
	
	@GetMapping("/")
	public String landing(Model model) {
		model.addAttribute("numeroPilotos", 10);
		model.addAttribute("karts", kartservice.findAll());
		return "index";
	}

}
