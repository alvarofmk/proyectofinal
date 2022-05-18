package com.salesianostriana.dam.karting.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.comparator.Comparators;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.karting.model.Participacion;
import com.salesianostriana.dam.karting.model.ParticipacionPK;
import com.salesianostriana.dam.karting.model.Piloto;
import com.salesianostriana.dam.karting.model.Sesion;
import com.salesianostriana.dam.karting.model.SesionWrapper;
import com.salesianostriana.dam.karting.model.Vuelta;
import com.salesianostriana.dam.karting.model.VueltaPK;
import com.salesianostriana.dam.karting.service.KartService;
import com.salesianostriana.dam.karting.service.ParticipacionService;
import com.salesianostriana.dam.karting.service.PilotoService;
import com.salesianostriana.dam.karting.service.SesionService;
import com.salesianostriana.dam.karting.service.VueltasService;

import lombok.val;

@Controller
@RequestMapping("/sesiones")
public class SesionController {
	
	@Autowired
	private KartService kartservice;
	@Autowired
	private PilotoService pilotoService;
	@Autowired
	private SesionService sesionService;
	@Autowired
	private ParticipacionService participacionService;
	@Autowired
	private VueltasService vueltasService;

	@GetMapping("/")
	public String sesionesAdmin(Model model) {
		SesionWrapper wrap = new SesionWrapper();
		model.addAttribute("karts", kartservice.findAll());
		model.addAttribute("listaSesiones", sesionService.findAll());
		model.addAttribute("listaPilotos", pilotoService.findAll());
		model.addAttribute("sesionWrap", wrap);
		model.addAttribute("mostrarForm", false);
		model.addAttribute("pilotosp", new ArrayList<Piloto>());
		return "sesiones";
	}
	
	@PostMapping("/edicion")
	public String addSesion(@ModelAttribute("sesionWrap") SesionWrapper sesionWrap,  Model model) {
		Optional<Sesion> sesionCheck = sesionService.findById(sesionWrap.getId());
		if (sesionCheck.isPresent()) {
			List<Piloto> pilotosABorrar = sesionCheck.get()
											.getParticipantes()
											.stream()
											.map(p -> p.getPiloto())
											.dropWhile(piloto -> sesionWrap.getPilotos().contains(piloto))
											.collect(Collectors.toList());
			if(!pilotosABorrar.isEmpty()) {
				pilotosABorrar.stream().forEach(piloto -> participacionService.delete(new Participacion(sesionCheck.get(), piloto)));
			}
		}
		
		sesionService.save(sesionWrap);
		return "redirect:/sesiones/";
	}
	
	@GetMapping("/update/{id}")
	public String actualizarSesion(@PathVariable("id") Long id,  Model model) {
		Optional<Sesion> aEditar = sesionService.findById(id);
		
		if (aEditar.isPresent()) {
			if(aEditar.get().getFechaSesion().isAfter(LocalDateTime.now())) {
				SesionWrapper sesion = new SesionWrapper(sesionService.findById(id).get());
				model.addAttribute("karts", kartservice.findAll());
				model.addAttribute("listaSesiones", sesionService.findAll());
				model.addAttribute("listaPilotos", pilotoService.findAll());
				model.addAttribute("sesionWrap", sesion);
				model.addAttribute("mostrarForm", true);
				model.addAttribute("pilotosp", new ArrayList<Piloto>());
				return "sesiones";
			}
		}
		
		return "redirect:/sesiones/?errorFecha=true";
		
	}
	
	@GetMapping("/remove/{id}")
	public String borrarSesion(@PathVariable("id") Long id,  Model model) {
		Optional<Sesion> aBorrar = sesionService.findById(id);
			
		if (aBorrar.isPresent()) {
			if(aBorrar.get().getFechaSesion().isAfter(LocalDateTime.now())) {
				sesionService.deleteById(id);
				return "redirect:/sesiones/";
			}
		}
		
		return "redirect:/sesiones/?errorFecha=true";
	}
	
	@GetMapping("/detalles/{id}")
	public String detallesSesionAdmin(@PathVariable("id") Long id, Model model) {
		Optional<Sesion> aConsultar = sesionService.findById(id);
		
		if (aConsultar.isPresent()) {
			if (aConsultar.get().getFechaSesion().isBefore(LocalDateTime.now())) {
				Sesion sesion = aConsultar.get();
				model.addAttribute("sesion", sesion);
				
				Map<Piloto, Vuelta> mejorVuelta = new HashMap<Piloto, Vuelta>();
				
				for (Participacion p : sesion.getParticipantes()) {
					
					mejorVuelta.put(p.getPiloto(), p.getRegistroVueltas().stream().min(Comparator.naturalOrder()).get());
				}
				
				LinkedHashMap<Piloto, Vuelta> resultados = new LinkedHashMap<>();
				mejorVuelta.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(e -> resultados.put(e.getKey(), e.getValue()));
				
				model.addAttribute("resultados", resultados);
				return "sesiondetalles"; 
			}
		}
		
		return "redirect:/sesiones/?errorDetalles=true";
	
	}
	
	@GetMapping("/detalles/penalizar/{sesionid}-{pilotodni}-{nvuelta}")
	public String detallesSesionAdmin(@PathVariable("sesionid") Long id, @PathVariable("pilotodni") String dni, @PathVariable("nvuelta") int nvuelta, Model model) {
		Participacion pilotoSesion = participacionService.findById(new ParticipacionPK(dni, id)).get();
		VueltaPK clavePrimaria = new VueltaPK(pilotoSesion, nvuelta);
		Vuelta v = vueltasService.findById(clavePrimaria).get();
		v.setTiempo(v.getTiempo().plusMillis(500));
		vueltasService.save(v);
		return "redirect:/sesiones/detalles/" + id;
	}

}
