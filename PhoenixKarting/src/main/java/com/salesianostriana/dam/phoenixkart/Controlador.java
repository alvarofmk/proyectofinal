package com.salesianostriana.dam.phoenixkart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
	
	@GetMapping("/")
	public String landing(Model model) {
		int numero = 10, numero2 = 3;
		model.addAttribute("numeroPilotos", numero);
		model.addAttribute("numeroKarts", numero2);
		return "index";
	}

}
