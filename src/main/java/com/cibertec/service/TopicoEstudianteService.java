package com.cibertec.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cibertec.entity.TopicoEstudiante;

public interface TopicoEstudianteService {
	
	public abstract List<TopicoEstudiante> listaTodosTopicoEstudiante();
	public abstract TopicoEstudiante insertarTopicoEstudiante(TopicoEstudiante obj);
	public abstract List<TopicoEstudiante> listaEstudiantePorIncidenteLike(String incidente);
	public abstract List<TopicoEstudiante> historialEstudiantePorId(int idEstudiante);
	//public abstract List<TopicoEstudiante> historialTopicoPorFechas(Calendar fechaini, Calendar fechafin);


}
