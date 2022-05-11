package com.salesianostriana.dam.karting.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
@Entity
public class Kart {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String descripcion;
	private String imgUrl;
	private double potencia;
	private double centimetrosCubicos;
	private double velocidadMaxima;
	private int edadMinima;
	private double precioSesion;
	
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="kart", fetch = FetchType.EAGER)
	private List<Sesion> sesiones = new ArrayList<>();
	
	public void addSesion(Sesion sesion) {
		this.sesiones.add(sesion);
		sesion.setKart(this);
	}
	
	public void removeSesion(Sesion sesion) {
		this.sesiones.remove(sesion);
		sesion.setKart(null);
	}

}
