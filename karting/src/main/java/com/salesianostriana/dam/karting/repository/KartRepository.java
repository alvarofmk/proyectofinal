package com.salesianostriana.dam.karting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.karting.model.Kart;

public interface KartRepository extends JpaRepository<Kart, Long> {
	
	public List<Kart> findByNombreLike (String nombre);

}
