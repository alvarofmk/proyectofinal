package com.salesianostriana.dam.karting.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SesionWrapper {
	
	public SesionWrapper(Sesion sesion) {
		super();
		this.id = sesion.getId();
		this.fechaReserva = sesion.getFechaReserva();
		this.fechaSesion = sesion.getFechaSesion();
		this.kart = sesion.getKart();
		this.pilotos = sesion.getParticipantes().stream().map(p -> p.getPiloto()).toList();
	}
	
	private long id;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime fechaReserva;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime fechaSesion;
	
	private Kart kart;
	private List<Piloto> pilotos;
	

}
