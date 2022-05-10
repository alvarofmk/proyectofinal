package com.salesianostriana.dam.karting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.karting.model.Sesion;
import com.salesianostriana.dam.karting.service.KartService;
import com.salesianostriana.dam.karting.service.PilotoService;
import com.salesianostriana.dam.karting.service.SesionService;

@Controller
public class SesionController {
	
	@Autowired
	private KartService kartservice;
	@Autowired
	private PilotoService pilotoService;
	@Autowired
	private SesionService sesionService;

	@GetMapping("/sesiones")
	public String sesionesAdmin(Model model) {
		Sesion nuevaSesion = new Sesion ();
		model.addAttribute("karts", kartservice.findAll());
		model.addAttribute("listaSesiones", sesionService.findAll());
		model.addAttribute("listaPilotos", pilotoService.findAll());
		model.addAttribute("nuevaSesion", nuevaSesion);
		return "sesiones";
	}
	
	@PostMapping("/addSesion")
	public String addSesion() {
		return "redirect:/sesiones";
	}
	
	@GetMapping("/sesiondetalles")
	public String detallesSesionAdmin(Model model) {
		model.addAttribute("sesion", sesionService.generarSesiones().get(0));
		return "sesiondetalles";
	}

}
