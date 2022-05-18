package com.salesianostriana.dam.karting.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.karting.model.Kart;
import com.salesianostriana.dam.karting.model.Participacion;
import com.salesianostriana.dam.karting.model.Piloto;
import com.salesianostriana.dam.karting.model.Vuelta;
import com.salesianostriana.dam.karting.model.VueltaPK;
import com.salesianostriana.dam.karting.repository.VueltaRepository;
import com.salesianostriana.dam.karting.service.baseservice.BaseService;

@Service
public class VueltasService extends BaseService<Vuelta, VueltaPK, VueltaRepository> {
	
	public VueltasService(VueltaRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}

	public List<Vuelta> generarVueltasPiloto (Participacion participacion, Duration tiempoLimite){
		int numeroVuelta = 1;
		Duration vueltaMedia = Duration.ofSeconds(Math.round((120-(participacion.getSesion().getKart().getPotencia()*0.8))));
		
		Duration desviacionMedia = Duration.ofMillis(Math.round(Math.random()*(6500-0)));
		if(Math.random()>0.5) {
			vueltaMedia = vueltaMedia.plus(desviacionMedia);
		}else {
			vueltaMedia = vueltaMedia.minus(desviacionMedia);
		}
		
		List<Vuelta> vueltas = new ArrayList<Vuelta>();
		Vuelta primeraVuelta = new Vuelta(participacion, numeroVuelta, vueltaMedia, true);
		vueltas.add(primeraVuelta);
		Duration sum = vueltaMedia;
		
		while(sum.compareTo(tiempoLimite)<0) {
			Duration desviacionVuelta = Duration.ofMillis(Math.round(Math.random()*(120-0)));
			Duration nuevaVuelta;
			
			if(Math.random()>0.55) {
				nuevaVuelta = vueltas.get(numeroVuelta-1).getTiempo().plus(desviacionVuelta);
			}else {
				nuevaVuelta = vueltas.get(numeroVuelta-1).getTiempo().minus(desviacionVuelta);
			}
			numeroVuelta++;
			vueltas.add(new Vuelta(participacion, numeroVuelta, nuevaVuelta, true));
			sum = sum.plus(nuevaVuelta);
		}
		
		this.saveAll(vueltas);
		participacion.setRegistroVueltas(vueltas);
		return vueltas;
	}


}
