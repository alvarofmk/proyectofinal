package com.salesianostriana.dam.karting.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.karting.model.Kart;
import com.salesianostriana.dam.karting.model.Piloto;
import com.salesianostriana.dam.karting.model.Sesion;
import com.salesianostriana.dam.karting.repository.SesionRepository;
import com.salesianostriana.dam.karting.service.baseservice.BaseService;

@Service
public class SesionService extends BaseService<Sesion, Long, SesionRepository> {
	
	public SesionService(SesionRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private VueltasService vueltasService;
	
	/*
	public void realizarSesion (Sesion sesion) {
		sesion.getParticipantes().stream().forEach(p -> vueltasService.generarVueltasPiloto(p, Duration.ofMinutes(15)));
		this.save(sesion);
	}
	*/
	public List<Sesion> generarSesiones (){
		List <Duration> vueltas = new ArrayList <Duration>();
		List <Sesion> sesiones = new ArrayList <Sesion>();
		/*
		sesiones.add(new Sesion(0, LocalDateTime.of(2022, 3, 2, 10, 32), LocalDateTime.of(2022, 3, 5, 18, 30), 40.0, 
				new Kart(001, "Junior", "Prueba", "", 12.5, 50.0, 60.0, 10, 12.0), new HashMap<Piloto, List<Duration>>() ));
		
		sesiones.get(0).getRegistroVueltas().put(new Piloto("78643876", "Alvaro", "Franco Martinez", "alvarofmk@gmail.com", "", LocalDate.of(1995, 11, 14)), vueltasService.generarVueltas(null, new Kart(001, "Junior", "Prueba", "", 12.5, 50.0, 60.0, 10, 12.0), Duration.ofMinutes(15)));
		sesiones.add(new Sesion(0, LocalDateTime.of(2022, 3, 2, 10, 32), LocalDateTime.of(2022, 3, 5, 18, 30), 40.0, 
				new Kart(001, "Junior", "Prueba", "", 12.5, 50.0, 60.0, 10, 12.0), new HashMap<Piloto, List<Duration>>() ));
		
		sesiones.get(1).getRegistroVueltas().put(new Piloto("78643876", "Alvaro", "Franco Martinez", "alvarofmk@gmail.com", "", LocalDate.of(1995, 11, 14)), vueltasService.generarVueltas(null, new Kart(001, "Junior", "Prueba", "", 12.5, 50.0, 60.0, 10, 12.0), Duration.ofMinutes(15)));
		sesiones.get(0).getRegistroVueltas().put(new Piloto("254364356", "Mamon", "Martinez", "alvarofmk@gmail.com", "", LocalDate.of(1995, 11, 14)), vueltasService.generarVueltas(null, new Kart(001, "Junior", "Prueba", "", 12.5, 50.0, 60.0, 10, 12.0), Duration.ofMinutes(15)));
		*/
		return sesiones;
	}

}
