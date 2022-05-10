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

	public List<Piloto> generarPilotos (){
		List <Piloto> pilotos = new ArrayList <Piloto>();
		/*
		pilotos.add(new Piloto("78643876", "Alvaro", "Franco Martinez", "alvarofmk@gmail.com", "", LocalDate.of(1995, 11, 14)));
		pilotos.add(new Piloto("82642378", "Pablo", "Franco Martinez", "pablomamon@gmail.com", "", LocalDate.of(2000, 6, 14)));
		pilotos.add(new Piloto("87623487", "Carlos", "Jesús Durbán", "Jesuseldeverdad@gmail.com", "", LocalDate.of(1002, 5, 1)));
		*/
		return pilotos;
	}

}
