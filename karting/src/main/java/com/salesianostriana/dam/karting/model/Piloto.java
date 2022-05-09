package com.salesianostriana.dam.karting.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Piloto {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private String email;
	private String imgUrl;
	private LocalDate fechaNacimiento;
	

}
