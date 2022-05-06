package com.salesianostriana.dam.karting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.karting.service.KartService;
import com.salesianostriana.dam.karting.service.PilotoService;

@Controller
public class MainController {
	
	@Autowired
	private KartService kartservice;
	@Autowired
	private PilotoService pilotoService;
	
	@GetMapping("/")
	public String landing(Model model) {
		model.addAttribute("numeroPilotos", 10);
		model.addAttribute("karts", kartservice.generarKarts());
		return "index";
	}
	
	@GetMapping("/karts")
	public String kartsAdmin(Model model) {
		model.addAttribute("karts", kartservice.generarKarts());
		return "karts";
	}
	
	@GetMapping("/pilotos")
	public String pilotosAdmin(Model model) {
		model.addAttribute("listaPilotos", pilotoService.generarPilotos());
		return "pilotos";
	}
	
	@GetMapping("/sesiones")
	public String sesionesAdmin(Model model) {
		model.addAttribute("listaPilotos", pilotoService.generarPilotos());
		return "sesiones";
	}

}
