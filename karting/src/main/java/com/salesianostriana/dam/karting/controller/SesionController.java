package com.salesianostriana.dam.karting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		model.addAttribute("karts", kartservice.generarKarts());
		model.addAttribute("listaSesiones", sesionService.generarSesiones());
		model.addAttribute("listaPilotos", pilotoService.generarPilotos());
		return "sesiones";
	}
	
	@GetMapping("/sesiondetalles")
	public String detallesSesionAdmin(Model model) {
		model.addAttribute("sesion", sesionService.generarSesiones().get(0));
		return "sesiondetalles";
	}

}
