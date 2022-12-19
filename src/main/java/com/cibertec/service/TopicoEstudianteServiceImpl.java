package com.cibertec.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.TopicoEstudiante;
import com.cibertec.repository.TopicoEstudianteRepository;

@Service
public class TopicoEstudianteServiceImpl implements TopicoEstudianteService{
	

	@Autowired
	private TopicoEstudianteRepository repository;

	@Override
	public List<TopicoEstudiante> listaTodosTopicoEstudiante() {
	   return repository.findAll();
	}

	@Override
	public TopicoEstudiante insertarTopicoEstudiante(TopicoEstudiante obj) {
		return repository.save(obj);
	}

	@Override
	public List<TopicoEstudiante> listaEstudiantePorIncidenteLike(String incidente) {
		return repository.listaTopicoEstuPorIncidenteLike(incidente);
	}

	@Override
	public List<TopicoEstudiante> historialEstudiantePorId(int idEstudiante) {
		return repository.historialEstudiandoPorId(idEstudiante);
	}
/*
	@Override
	public List<TopicoEstudiante> historialTopicoPorFechas(Calendar fechaini, Calendar fechafin) {
		return repository.historialTopicoPorFechas(fechaini, fechafin);
	}
	*/
	


}
