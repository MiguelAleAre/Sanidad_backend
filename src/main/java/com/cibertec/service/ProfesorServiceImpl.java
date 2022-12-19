package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Profesor;
import com.cibertec.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	ProfesorRepository repository;

	@Override
	public Profesor insertaActualizaProfesor(Profesor profesor) {
		return repository.save(profesor);
		}

	@Override
	public List<Profesor> listaProfesorPorDniLike(String dni) {
		return repository.listaProfesorPorDniLike(dni); 
	}

	@Override
	public void eliminaProfesores(int idProfesor) {
		repository.deleteById(idProfesor);
		
	}

}
