package com.salesianostriana.dam.karting.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.karting.model.Kart;
import com.salesianostriana.dam.karting.model.Piloto;

@Service
public class VueltasService {
	
	public List<Duration> generarVueltas (Piloto conductor, Kart kartUsado, Duration tiempoLimite){
		Duration vueltaMedia = Duration.ofSeconds(Math.round((120-(kartUsado.getPotencia()*0.8))));
		
		Duration desviacionMedia = Duration.ofSeconds(Math.round(Math.random()*(6-0)), Math.round(Math.random()*(999-0)));
		if(Math.random()>0.5) {
			vueltaMedia = vueltaMedia.plus(desviacionMedia);
		}else {
			vueltaMedia = vueltaMedia.minus(desviacionMedia);
		}
		
		List<Duration> vueltas = new ArrayList<Duration>();
		vueltas.add(vueltaMedia);
		Duration sum = vueltaMedia;
		
		while(sum.compareTo(tiempoLimite)<0) {
			Duration desviacionVuelta = Duration.ofMillis(Math.round(Math.random()*(120-0)));
			Duration nuevaVuelta;
			
			if(Math.random()>0.55) {
				nuevaVuelta = vueltas.get(vueltas.size()-1).plus(desviacionVuelta);
			}else {
				nuevaVuelta = vueltas.get(vueltas.size()-1).minus(desviacionVuelta);
			}
			vueltas.add(nuevaVuelta);
			sum = sum.plus(nuevaVuelta);
		}
		return vueltas;
	}

}
