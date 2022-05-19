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
		
		Sesion guardada = save(sesionAEditar);
		
		wrap.getPilotos().stream().forEach(p -> participacionService.addParticipacion(p, guardada));
		guardada.setPrecio(calcularPrecioSesion(guardada));
		
		return save(guardada);
	}
	
	public double calcularPrecioSesion (Sesion s) {
		double precio = s.getParticipantes().stream().mapToDouble(p -> p.getPrecio()).sum();
		if(s.getParticipantes().size() >= 5) {
			precio *= 0.9;
			double precioIndividual = precio / s.getParticipantes().size();
			s.getParticipantes().stream().forEach( (p) -> {
																p.setPrecio(precioIndividual);
																participacionService.edit(p);
															});
		}
		return precio;
	}

	
	public List<Sesion> encontrarSesionesAEjecutar (){
		return repositorio.findSesionWithNoLaps();
	}

	public void realizarSesiones (List<Sesion> sesiones) {
		sesiones.stream().forEach(s -> realizarSesion(s));
	}
	
	public void realizarSesion (Sesion sesion) {
		sesion.getParticipantes().forEach(p -> vueltasService.generarVueltasPiloto(p, Duration.ofMinutes(15)));
	}
	
	public double recaudadoHoy () {
		return repositorio.findEarnedToday();
	}
	
	public double recaudadoMes () {
		return repositorio.findEarnedThisMonth();
	}
	
	public double recaudadoAnio () {
		return repositorio.findEarnedThisYear();
	}
	
}
