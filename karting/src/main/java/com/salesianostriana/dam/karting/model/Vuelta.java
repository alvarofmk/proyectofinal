package com.salesianostriana.dam.karting.model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@IdClass(VueltaPK.class)
public class Vuelta {
	
	@Id
	@ManyToOne
	private Participacion participacion;
	
	@Id
	private int numeroVuelta;
	
	private Duration tiempo;

}
