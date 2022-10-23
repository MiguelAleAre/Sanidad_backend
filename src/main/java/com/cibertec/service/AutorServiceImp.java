package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Autor;
import com.cibertec.repository.AutorRepository;

@Service
public class AutorServiceImp implements AutorService {

	@Autowired
	private AutorRepository repository;
	
	@Override
	public Autor insertaAutor(Autor obj) {
		
		return repository.save(obj);
	}

	@Override
	public List<Autor> listaAutorporParametros(String nombres, String estado, int idGrado, String fechInicio,
			String fechFin) {
		
		return repository.listaAutorporParametros(nombres, estado, idGrado, fechInicio,  fechFin);
	}

}
