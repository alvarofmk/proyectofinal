package com.salesianostriana.dam.karting.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ParticipacionPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String piloto_dni;
	
	private long sesion_id;

}
