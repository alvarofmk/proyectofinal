package com.salesianostriana.dam.karting.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.karting.model.Kart;
import com.salesianostriana.dam.karting.model.Piloto;
import com.salesianostriana.dam.karting.repository.KartRepository;
import com.salesianostriana.dam.karting.repository.PilotoRepository;
import com.salesianostriana.dam.karting.service.baseservice.BaseService;

@Service
public class PilotoService extends BaseService<Piloto, String, PilotoRepository> {
	
	public PilotoService(PilotoRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}

	public List<Piloto> buscarPorNombre (String nombre, String apellidos, String email, String dni){
		return repositorio.findByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCaseOrEmailContainsIgnoreCaseOrDniIgnoreCase(nombre, apellidos, email, dni);
	}

	public int contarSesionesPorPiloto (Piloto piloto) {
		return repositorio.findNumSesionesByPiloto(piloto);
	}
	
}
