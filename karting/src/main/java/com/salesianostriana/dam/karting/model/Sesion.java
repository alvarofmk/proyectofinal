package com.salesianostriana.dam.karting.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sesion {
	
	private int id;
	private LocalDateTime fechaReserva;
	private LocalDateTime fechaSesion;
	private double precio;
	private Kart kart;
	private Map <Piloto, List<Duration>> registroVueltas;
}
