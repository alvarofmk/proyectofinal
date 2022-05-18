package com.salesianostriana.dam.karting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.karting.model.Participacion;
import com.salesianostriana.dam.karting.model.ParticipacionPK;
import com.salesianostriana.dam.karting.model.Piloto;
import com.salesianostriana.dam.karting.model.Sesion;
import com.salesianostriana.dam.karting.repository.ParticipacionRepository;
import com.salesianostriana.dam.karting.service.baseservice.BaseService;

@Service
public class ParticipacionService extends BaseService<Participacion, ParticipacionPK, ParticipacionRepository> {
	
	@Autowired
	private PilotoService pilotoService;

	public ParticipacionService(ParticipacionRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}
	
	public Sesion addParticipacion(Piloto piloto, Sesion sesion) {
		Participacion p = new Participacion(sesion, piloto, sesion.getKart().getPrecioSesion());
		//cambiar esto por generacion de precios
		
		sesion.getParticipantes().add(p);
		piloto.getParticipaciones().add(p);
		
		//no hace falta guardar piloto
		// pilotoService.save(piloto);
		this.save(p);
		return sesion;
	}
	

}
