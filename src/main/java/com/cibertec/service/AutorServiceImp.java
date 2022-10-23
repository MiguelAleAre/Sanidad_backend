package com.cibertec.service;

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

}
