package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.VacunacionEstudiante;
import com.cibertec.repository.VacunacionEstudianteRepository;

@Service
public class VacunacionEstudianteServiceImpl implements VacunacionEstudianteService {
	
	@Autowired
	VacunacionEstudianteRepository repository;

	@Override
	public List<VacunacionEstudiante> listaTodosVacunacionEstudiante() {
		return repository.findAll();
	}

	@Override
	public VacunacionEstudiante insertarVacunacionEstudiante(VacunacionEstudiante obj) {
		return repository.save(obj);
	}

}
