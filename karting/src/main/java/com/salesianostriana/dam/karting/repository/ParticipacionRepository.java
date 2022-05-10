package com.salesianostriana.dam.karting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.karting.model.Participacion;
import com.salesianostriana.dam.karting.model.ParticipacionPK;

public interface ParticipacionRepository extends JpaRepository<Participacion, ParticipacionPK> {

}
