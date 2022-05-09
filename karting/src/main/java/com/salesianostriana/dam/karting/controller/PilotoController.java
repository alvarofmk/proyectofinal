package com.salesianostriana.dam.karting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.karting.service.PilotoService;

@Controller
public class PilotoController {
	
	@Autowired
	private PilotoService pilotoService;
	
	@GetMapping("/pilotos")
	public String pilotosAdmin(Model model) {
		model.addAttribute("listaPilotos", pilotoService.generarPilotos());
		return "pilotos";
	}

}
