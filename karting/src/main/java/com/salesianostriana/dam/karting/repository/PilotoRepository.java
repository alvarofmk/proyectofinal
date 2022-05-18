package com.salesianostriana.dam.karting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.karting.model.Kart;
import com.salesianostriana.dam.karting.model.Piloto;

public interface PilotoRepository extends JpaRepository<Piloto, String> {
	
	public List<Piloto> findByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCaseOrEmailContainsIgnoreCaseOrDniIgnoreCase (String nombre, String apellidos, String email, String dni);

	@Query("select count(p) from Participacion p where p.piloto = ?1")
	public int findNumSesionesByPiloto (Piloto piloto);
	
}
