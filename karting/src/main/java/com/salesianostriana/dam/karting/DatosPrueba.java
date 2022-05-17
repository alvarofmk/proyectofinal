package com.salesianostriana.dam.karting;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.karting.model.Kart;
import com.salesianostriana.dam.karting.model.Participacion;
import com.salesianostriana.dam.karting.model.Piloto;
import com.salesianostriana.dam.karting.model.Sesion;
import com.salesianostriana.dam.karting.service.KartService;
import com.salesianostriana.dam.karting.service.ParticipacionService;
import com.salesianostriana.dam.karting.service.PilotoService;
import com.salesianostriana.dam.karting.service.SesionService;
import com.salesianostriana.dam.karting.service.VueltasService;

@Component
public class DatosPrueba {
	
	/*
	@Autowired
	private PilotoService pilotoService;
	
	@Autowired
	private KartService kartService;
	
	@Autowired
	private ParticipacionService participacionService;
	
	@Autowired
	private VueltasService vueltasService;
	
	@Autowired
	private SesionService sesionService;
	
	@PostConstruct
	public void generarDatos () {
		
		Algo debe fallar en addParticipacion() o dentro con VueltaPK
		 
		for (Piloto piloto : pilotosPre) {
			participacionService.addParticipacion(piloto, carrera);
		}
		
		sesionService.realizarSesion(carrera);
		
	}
	*/
	
}
