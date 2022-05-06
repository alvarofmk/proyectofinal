package com.salesianostriana.dam.karting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.karting.model.Kart;

@Service
public class KartService {
	
	public List<Kart> generarKarts (){
		List <Kart> karts = new ArrayList <Kart>();
		karts.add(new Kart(001, "Junior", "Prueba", "", 12.5, 50.0, 60.0, 10, 12.0));
		karts.add(new Kart(002, "Senior", "Prueba2", "", 25.5, 56.0, 70.0, 18, 14.0));
		karts.add(new Kart(003, "Competicion", "Prueba3", "", 60, 250.0, 95.0, 20, 18.0));
		karts.add(new Kart(004, "Competicion", "Prueba3", "", 60, 250.0, 95.0, 20, 18.0));
		return karts;
	}

}
