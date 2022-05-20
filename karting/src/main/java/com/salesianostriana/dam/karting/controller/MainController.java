package com.salesianostriana.dam.karting.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.karting.model.Sesion;
import com.salesianostriana.dam.karting.service.KartService;
import com.salesianostriana.dam.karting.service.PilotoService;
import com.salesianostriana.dam.karting.service.SesionService;

@Controller
public class MainController {
	
	@Autowired
	private PilotoService pilotoService;
	
	@Autowired
	private KartService kartservice;
	
	@Autowired
	private SesionService sesionService;
	
	@GetMapping("/")
	public String landing(Model model) {
		model.addAttribute("numeroPilotos", pilotoService.findAll().size());
		model.addAttribute("karts", kartservice.findAll());
		model.addAttribute("sesion", new Sesion());
		return "index";
	}
	
	@GetMapping("/login")
	public String landingLogged(Model model) {
		model.addAttribute("numeroPilotos", pilotoService.findAll().size());
		model.addAttribute("karts", kartservice.findAll());
		model.addAttribute("sesion", new Sesion());
		return "index";
	}
	
	@GetMapping("/login-error")
	public String loginFail(Model model) {
		model.addAttribute("numeroPilotos", pilotoService.findAll().size());
		model.addAttribute("karts", kartservice.findAll());
		model.addAttribute("error", true);
		model.addAttribute("sesion", new Sesion());
		return "index";
	}
	
	@PostMapping("/nuevaReserva")
	public String addSesion(@ModelAttribute("sesion") Sesion sesion,  Model model) {
		sesion.setFechaReserva(LocalDateTime.now());
		sesionService.save(sesion);
		model.addAttribute("reserva", sesion);
		return "resumenReserva";
	}
	
	@GetMapping("/errorAcceso")
	public String errorPermiso() {
		return "errorAcceso";
	}

}
