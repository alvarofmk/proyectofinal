package com.salesianostriana.dam.karting;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.karting.model.Kart;
import com.salesianostriana.dam.karting.model.Participacion;
import com.salesianostriana.dam.karting.model.Piloto;
import com.salesianostriana.dam.karting.model.Sesion;
import com.salesianostriana.dam.karting.service.KartService;
import com.salesianostriana.dam.karting.service.ParticipacionService;
import com.salesianostriana.dam.karting.service.PilotoService;
import com.salesianostriana.dam.karting.service.SesionService;
import com.salesianostriana.dam.karting.service.VueltasService;

@Component
public class DatosPrueba {
	
	@Autowired
	private PilotoService pilotoService;
	
	@Autowired
	private KartService kartService;
	
	@Autowired
	private ParticipacionService participacionService;
	
	@Autowired
	private VueltasService vueltasService;
	
	@Autowired
	private SesionService sesionService;
	
	@PostConstruct
	public void generarDatos () {
		
		List<Piloto> pilotosPre = List.of(Piloto.builder()
					.dni("54219289D")
					.nombre("Alvaro")
					.apellidos("Franco Martínez")
					.email("alvaro@gmail.com")
					.imgUrl(null)
					.fechaNacimiento(LocalDate.of(1995, 11, 14))
					.build(),
					
					Piloto.builder()
					.dni("58792129D")
					.nombre("Pablo")
					.apellidos("Franco Martínez")
					.email("pablo@gmail.com")
					.imgUrl(null)
					.fechaNacimiento(LocalDate.of(2001, 06, 1))
					.build(),
					
					Piloto.builder()
					.dni("23542345E")
					.nombre("Alejandro")
					.apellidos("Gonzalez")
					.email("ale@gmail.com")
					.imgUrl(null)
					.fechaNacimiento(LocalDate.of(1995, 10, 2))
					.build(),
					
					Piloto.builder()
					.dni("98237421Q")
					.nombre("Miguel Angel")
					.apellidos("Bailón")
					.email("miguel@gmail.com")
					.imgUrl(null)
					.fechaNacimiento(LocalDate.of(1996, 7, 1))
					.build(),
					
					Piloto.builder()
					.dni("9823674A")
					.nombre("Jose Antonio")
					.apellidos("Espinal")
					.email("jose@gmail.com")
					.imgUrl(null)
					.fechaNacimiento(LocalDate.of(1996, 8, 8))
					.build()
				
				);
		
		pilotoService.saveAll(pilotosPre);
		
		Sesion carrera = Sesion.builder()
					.fechaReserva(LocalDateTime.now().minusDays(3))
					.fechaSesion(LocalDateTime.now().minusDays(1))
					.kart(kartService.findAll().get(1))
					.build();
		
		sesionService.save(carrera);
		
		/*	Algo debe fallar en addParticipacion() o dentro con VueltaPK
		 
		for (Piloto piloto : pilotosPre) {
			participacionService.addParticipacion(piloto, carrera);
		}
		
		sesionService.realizarSesion(carrera);
		*/
	}
	
}
