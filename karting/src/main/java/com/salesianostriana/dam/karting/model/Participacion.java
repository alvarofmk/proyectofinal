package com.salesianostriana.dam.karting.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Participacion {
	
	public Participacion(Sesion sesion, Piloto piloto) {
		this.sesion = sesion;
		this.piloto = piloto;
		
		//asignar ids
		id.setPiloto_dni(this.piloto.getDni());
		id.setSesion_id(this.sesion.getId());
		
	}
	
	public Participacion(Sesion sesion, Piloto piloto, double precio) {
		this.sesion = sesion;
		this.piloto = piloto;
		this.precio = precio;
		
		//asignar ids
		id.setPiloto_dni(this.piloto.getDni());
		id.setSesion_id(this.sesion.getId());
		
	}
	
	//crear instancia
	@EmbeddedId
	private ParticipacionPK id = new ParticipacionPK();
	
	@ManyToOne
	@MapsId("sesion_id")
	@JoinColumn(name="sesion_id")
	private Sesion sesion;
	
	@ManyToOne
	@MapsId("piloto_dni")
	@JoinColumn(name="piloto_dni")
	private Piloto piloto;
	
	@OneToMany(mappedBy="participacion")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Vuelta> registroVueltas = new ArrayList<>();
	
	private double precio;
	
	public void addVuelta(Vuelta v) {
		this.registroVueltas.add(v);
		v.setParticipacion(this);
	}
	
	public void removeVuelta(Vuelta v) {
		this.registroVueltas.remove(v);
		v.setParticipacion(null);
	}

}
