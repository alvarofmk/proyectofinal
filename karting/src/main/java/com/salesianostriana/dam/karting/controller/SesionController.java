package com.salesianostriana.dam.karting.controller;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.karting.model.Piloto;
import com.salesianostriana.dam.karting.model.Sesion;
import com.salesianostriana.dam.karting.service.KartService;
import com.salesianostriana.dam.karting.service.PilotoService;
import com.salesianostriana.dam.karting.service.SesionService;

@Controller
@RequestMapping("/sesiones")
public class SesionController {
	
	@Autowired
	private KartService kartservice;
	@Autowired
	private PilotoService pilotoService;
	@Autowired
	private SesionService sesionService;

	@GetMapping("/")
	public String sesionesAdmin(Model model) {
		Sesion sesion = new Sesion ();
		model.addAttribute("karts", kartservice.findAll());
		model.addAttribute("listaSesiones", sesionService.findAll());
		model.addAttribute("listaPilotos", pilotoService.findAll());
		model.addAttribute("sesion", sesion);
		model.addAttribute("mostrarForm", false);
		return "sesiones";
	}
	
	@PostMapping("/edicion")
	public String addSesion(@ModelAttribute("sesion") Sesion sesion,  Model model) {
		if(sesion.getFechaReserva() == null) {
			sesion.setFechaReserva(LocalDateTime.now());
		}
		sesionService.save(sesion);
		return "redirect:/sesiones/";
	}
	
	@GetMapping("/update/{id}")
	public String actualizarPiloto(@PathVariable("id") Long id,  Model model) {
		model.addAttribute("karts", kartservice.findAll());
		model.addAttribute("listaSesiones", sesionService.findAll());
		model.addAttribute("listaPilotos", pilotoService.findAll());
		model.addAttribute("sesion", sesionService.findById(id));
		model.addAttribute("mostrarForm", true);
		return "sesiones";
	}
	
	@GetMapping("/remove/{id}")
	public String borrarSesion(@PathVariable("id") Long id,  Model model) {
		sesionService.deleteById(id);
		return "redirect:/sesiones/";
	}
	
	@GetMapping("/detalles/{id}")
	public String detallesSesionAdmin(@PathVariable("id") Long id, Model model) {
		Sesion sesion = sesionService.findById(id);
		model.addAttribute("sesion", sesion);
		return "sesiondetalles";
	}

}
