package com.salesianostriana.dam.phoenixkart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import model.Kart;

@Controller
public class Controlador {
	
	@GetMapping("/")
	public String landing(Model model) {
		List <Kart> karts = new ArrayList <Kart>();
		karts.add(new Kart("Junior", "Prueba", 12.5, 50.0, 60.0, 10, 12.0));
		karts.add(new Kart("Senior", "Prueba2", 25.5, 56.0, 70.0, 18, 14.0));
		karts.add(new Kart("Competicion", "Prueba3", 60, 250.0, 95.0, 20, 18.0));
		model.addAttribute("numeroPilotos", 10);
		model.addAttribute("numeroKarts", 3);
		model.addAttribute("karts", karts);
		return "index";
	}

}
