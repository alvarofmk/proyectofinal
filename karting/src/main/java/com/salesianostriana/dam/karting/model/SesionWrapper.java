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
	
	private long id;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime fechaReserva;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime fechaSesion;
	
	private Kart kart;
	private List<Piloto> pilotos;
	

}
