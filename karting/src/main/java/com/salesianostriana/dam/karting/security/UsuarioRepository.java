package com.salesianostriana.dam.karting.security;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {
	
	private List<Usuario> usuarios;
	
	public List<Usuario> getUsuarios() {
		return Collections.unmodifiableList(usuarios);
	}
	
	@PostConstruct
	public void init() {
		usuarios = List.of(
				Usuario.builder()
					.username("admin")
					.password("admin")
					.role("ADMIN")
					.build()
					,
					Usuario.builder()
					.username("user")
					.password("1234")
					.role("USER")
					.build()
				);
				
	}
	
	public Optional<Usuario> findUserByUsername(String username) {
		return usuarios.stream()
				.filter(u -> u.getUsername().equals(username))
				.findFirst();
	}

}
