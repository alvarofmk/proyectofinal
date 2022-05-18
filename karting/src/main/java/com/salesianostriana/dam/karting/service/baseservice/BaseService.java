package com.salesianostriana.dam.karting.service.baseservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public class BaseService <T, ID, R extends JpaRepository<T, ID>> implements BaseServiceInterface<T, ID> {
	
	protected R repositorio;
	
	public BaseService (R repositorio) {
		this.repositorio=repositorio;
	}

	@Override
	public T save(T t) {
		return repositorio.save(t);
	}
	
	public List<T> saveAll(List<T> list){
		return repositorio.saveAll(list);
	}

	@Override
	public Optional<T> findById(ID id) {
		return Optional.ofNullable(repositorio.findById(id).orElse(null));
	}

	@Override
	public List<T> findAll() {
		return repositorio.findAll();
	}

	@Override
	public T edit(T t) {
		return repositorio.save(t);
	}

	@Override
	public void delete(T t) {
		repositorio.delete(t);
	}

	@Override
	public void deleteById(ID id) {
		repositorio.deleteById(id);
	}

}
