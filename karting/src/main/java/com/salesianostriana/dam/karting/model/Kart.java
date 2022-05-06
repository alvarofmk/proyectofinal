package com.salesianostriana.dam.karting.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Kart {
	
	private int id;
	private String nombre;
	private String descripcion;
	private String imgUrl;
	private double potencia;
	private double centimetrosCubicos;
	private double velocidadMaxima;
	private int edadMinima;
	private double precioSesion;

}
