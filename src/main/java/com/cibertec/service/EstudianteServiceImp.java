package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Estudiante;
import com.cibertec.repository.EstudianteRepository;

@Service
public class EstudianteServiceImp implements EstudianteService{
	
	@Autowired
	private EstudianteRepository Repository;

	@Override
	public List<Estudiante> listaTodos() {
		return Repository.findAll();
	}

	@Override
	public Estudiante insertaActualizaEstudiante(Estudiante estudiante) {
		return Repository.save(estudiante);
	}

	@Override
	public List<Estudiante> listaEstudiantePorNombreLike(String nombre) {
		return Repository.listaEstudiantePorNombreLike(nombre);
	}

	@Override
	public void eliminaEstudiantes(int idEstudiante) {
		Repository.deleteById(idEstudiante);
		
	}

	

}
