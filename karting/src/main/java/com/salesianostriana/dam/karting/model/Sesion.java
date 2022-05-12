package com.salesianostriana.dam.karting.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
public class Sesion {
	
	@Id @GeneratedValue
	private long id;
	
	private LocalDateTime fechaReserva;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime fechaSesion;
	private double precio;
	
	@ManyToOne
	private Kart kart;
	
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="sesion", fetch = FetchType.EAGER)
	private List<Participacion> participantes = new ArrayList<Participacion>();
	
}
