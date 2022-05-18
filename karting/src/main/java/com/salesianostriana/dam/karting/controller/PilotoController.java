package com.salesianostriana.dam.karting.controller;

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
import com.salesianostriana.dam.karting.model.Piloto;
import com.salesianostriana.dam.karting.service.PilotoService;

@Controller
@RequestMapping("/pilotos")
public class PilotoController {
	
	@Autowired
	private PilotoService pilotoService;
	
	@GetMapping("/")
	public String pilotosAdmin(Model model) {
		model.addAttribute("listaPilotos", pilotoService.findAll());
		model.addAttribute("piloto", new Piloto());
		model.addAttribute("mostrarForm", false);
		return "pilotos";
	}
	
	@GetMapping("/update/{id}")
	public String actualizarPiloto(@PathVariable("id") String dni,  Model model) {
		model.addAttribute("listaPilotos", pilotoService.findAll());
		model.addAttribute("piloto", pilotoService.findById(dni));
		model.addAttribute("mostrarForm", true);
		return "pilotos";
	}
	
	@GetMapping("/remove/{id}")
	public String borrarPiloto(@PathVariable("id") String dni,  Model model) {
		Optional<Piloto> aBorrar = pilotoService.findById(dni);
		
		if(aBorrar.isPresent()) {
			if(pilotoService.contarSesionesPorPiloto(aBorrar.get()) == 0) {
				pilotoService.deleteById(dni);
			}else {
				return "redirect:/pilotos/?error=true";
			}
		}
		return "redirect:/pilotos/";
	}
	
	@PostMapping("/edicion")
	public String addPiloto(@ModelAttribute("nuevoPiloto") Piloto nuevoPiloto,  Model model) {
		pilotoService.save(nuevoPiloto);
		return "redirect:/pilotos/";
	}
	
	@GetMapping("/busqueda")
	public String buscarPiloto(@RequestParam("nombre")String busqueda,  Model model) {
		model.addAttribute("listaPilotos", pilotoService.buscarPorNombre(busqueda, busqueda, busqueda, busqueda));
		model.addAttribute("piloto", new Piloto());
		model.addAttribute("mostrarForm", false);
		return "pilotos";
	}

}
