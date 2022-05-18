package com.salesianostriana.dam.karting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.karting.model.Kart;
import com.salesianostriana.dam.karting.service.KartService;

@Controller
@RequestMapping("/karts")
public class KartController {
	
	@Autowired
	private KartService kartservice;
	
	@GetMapping("/")
	public String kartsAdmin(Model model) {
		Kart kart = new Kart();
		model.addAttribute("karts", kartservice.findAll());
		model.addAttribute("kart", kart);
		model.addAttribute("mostrarForm", false);
		return "karts";
	}
	
	@GetMapping("/update/{id}")
	public String actualizarKart(@PathVariable("id") long id,  Model model) {
		model.addAttribute("karts", kartservice.findAll());
		model.addAttribute("kart", kartservice.findById(id).get());
		model.addAttribute("mostrarForm", true);
		return "karts";
	}
	
	@GetMapping("/remove/{id}")
	public String borrarKart(@PathVariable("id") long id,  Model model) {
		Optional<Kart> aBorrar = kartservice.findById(id);
		if(aBorrar.isPresent()) {
			if(kartservice.contarSesionesPorKart(aBorrar.get()) == 0) {
				kartservice.deleteById(id);
			}else {
				return "redirect:/karts/?error=true";
			}
			
		}
		
		return "redirect:/karts/";
	}
	
	@GetMapping("/busqueda")
	public String buscarKart(@RequestParam("nombre")String nombre,  Model model) {
		Kart kart = new Kart();
		model.addAttribute("karts", kartservice.buscarPorNombre(nombre));
		model.addAttribute("kart", kart);
		model.addAttribute("mostrarForm", false);
		return "karts";
	}
	
	@PostMapping("/edicion")
	public String guardarKart(@ModelAttribute("kart") Kart kart,  Model model) {
		kartservice.edit(kart);
		return "redirect:/karts/";
	}

}
