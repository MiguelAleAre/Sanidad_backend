package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.VacunacionEstudiante;

public interface VacunacionEstudianteService {
	
	public abstract List<VacunacionEstudiante> listaTodosVacunacionEstudiante();
	public abstract VacunacionEstudiante insertarVacunacionEstudiante(VacunacionEstudiante obj);

}
