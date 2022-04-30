package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Kart {
	
	private String nombre;
	private String descripcion;
	private double potencia;
	private double centimetrosCubicos;
	private double velocidadMaxima;
	private int edadMinima;
	private double precioSesion;

}
