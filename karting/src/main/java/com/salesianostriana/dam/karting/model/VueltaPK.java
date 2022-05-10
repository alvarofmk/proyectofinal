package com.salesianostriana.dam.karting.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class VueltaPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	protected Participacion participacion;
	
	protected int numeroVuelta;
	
}
