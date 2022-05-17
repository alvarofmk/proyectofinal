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
import com.salesianostriana.dam.karting.model.SesionWrapper;
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
	
	@Autowired
	private ParticipacionService participacionService;

	public Sesion save(SesionWrapper wrap) {
		Sesion sesionAEditar = new Sesion(wrap.getId(), wrap.getFechaSesion(), wrap.getKart());
		
		if(wrap.getFechaReserva()==null) {
			sesionAEditar.setFechaReserva(LocalDateTime.now());
		}else {
			sesionAEditar.setFechaReserva(wrap.getFechaReserva());
		}
		
		wrap.getPilotos().stream().forEach(p -> participacionService.addParticipacion(p, sesionAEditar));
		sesionAEditar.setPrecio(calcularPrecioSesion(sesionAEditar));
		
		return save(sesionAEditar);
	}
	
	public double calcularPrecioSesion (Sesion s) {
		return s.getParticipantes().size() * s.getKart().getPrecioSesion();
	}

	
	
	/*
	public void realizarSesion (Sesion sesion) {
		sesion.getParticipantes().stream().forEach(p -> vueltasService.generarVueltasPiloto(p, Duration.ofMinutes(15)));
		this.save(sesion);
	}
	*/
	

}
