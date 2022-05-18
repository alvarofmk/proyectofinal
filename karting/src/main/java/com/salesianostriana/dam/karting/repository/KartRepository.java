package com.salesianostriana.dam.karting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.karting.model.Kart;

public interface KartRepository extends JpaRepository<Kart, Long> {
	
	public List<Kart> findByNombreContainsIgnoreCase (String nombre);
	
	@Query("select count(s) from Sesion s where s.kart = ?1")
	public int findNumSesionesByKart (Kart kart);

}
