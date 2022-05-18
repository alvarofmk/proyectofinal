package com.salesianostriana.dam.karting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.karting.model.Kart;
import com.salesianostriana.dam.karting.model.Sesion;

public interface SesionRepository extends JpaRepository<Sesion, Long> {
	
	@Query("SELECT DISTINCT s FROM Sesion s WHERE s.fechaSesion < now() AND s.id NOT IN (SELECT DISTINCT v.participacion.sesion.id FROM Vuelta v)")
	public List<Sesion> findSesionWithNoLaps ();

}
