package com.salesianostriana.dam.karting.service;

import com.salesianostriana.dam.karting.model.Participacion;
import com.salesianostriana.dam.karting.model.ParticipacionPK;
import com.salesianostriana.dam.karting.repository.ParticipacionRepository;
import com.salesianostriana.dam.karting.service.baseservice.BaseService;

public class ParticipacionService extends BaseService<Participacion, ParticipacionPK, ParticipacionRepository> {

	public ParticipacionService(ParticipacionRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}

}
