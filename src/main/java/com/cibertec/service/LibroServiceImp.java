package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Libro;
import com.cibertec.repository.LibroRepository;

@Service
public class LibroServiceImp implements LibroService {

	@Autowired
	private LibroRepository repository;

	@Override
	public Libro insertaActualizaLibro(Libro obj) {
		return repository.save(obj);
	}

	@Override
	public List<Libro> listaLibro() {
		return repository.findAll();
	}
}
