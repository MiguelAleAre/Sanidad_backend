package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.TopicoProfesor;
import com.cibertec.repository.TopicoProfesorRepository;

@Service
public class TopicoProfesorServiceImpl implements TopicoProfesorService {
	
	@Autowired
	TopicoProfesorRepository repository;

	@Override
	public List<TopicoProfesor> listaTodosTopicoProfesor() {
		return repository.findAll();
		}

	@Override
	public TopicoProfesor insertarTopicoProfesor(TopicoProfesor obj) {
		return repository.save(obj);
	}

	@Override
	public List<TopicoProfesor> listaProfesorPorIncidenteLike(String incidente) {
		return repository.listaTopicoProfePorIncidenteLike(incidente);
	}

	@Override
	public List<TopicoProfesor> historialProfesorPorId(int idProfesor) {
		return repository.historialProfePorId(idProfesor);
	}

}
