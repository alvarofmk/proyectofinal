package com.salesianostriana.dam.karting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.karting.model.Vuelta;
import com.salesianostriana.dam.karting.model.VueltaPK;

public interface VueltaRepository extends JpaRepository<Vuelta, VueltaPK> {

}
