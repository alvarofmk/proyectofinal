package com.salesianostriana.dam.karting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.karting.model.Piloto;
import com.salesianostriana.dam.karting.service.PilotoService;

@Controller
public class PilotoController {
	
	@Autowired
	private PilotoService pilotoService;
	
	@GetMapping("/pilotos")
	public String pilotosAdmin(Model model) {
		Piloto nuevoPiloto = new Piloto();
		model.addAttribute("listaPilotos", pilotoService.generarPilotos());
		model.addAttribute("nuevoPiloto", nuevoPiloto);
		return "pilotos";
	}
	
	@PostMapping("/addpiloto")
	public String addPiloto() {
		return "redirect:/pilotos";
	}

}
