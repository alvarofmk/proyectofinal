package com.salesianostriana.dam.karting.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class ParticipacionPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	String piloto_dni;
	
	long sesion_id;

}
