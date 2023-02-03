package com.cibertec.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cibertec.entity.Estudiante;
import com.cibertec.entity.TopicoEstudiante;

public interface TopicoEstudianteService {
	
	public abstract List<TopicoEstudiante> listaTodosTopicoEstudiante();
	public abstract TopicoEstudiante insertarTopicoEstudiante(TopicoEstudiante obj);
	public abstract List<TopicoEstudiante> listaEstudiantePorIncidenteLike(String incidente);
	public abstract List<TopicoEstudiante> buscaHistorialAlumno(int idEstudiante);
	public abstract List<TopicoEstudiante> historialTopicoPorFechasMensual(String fechaini, String fechafin);
	public abstract List<TopicoEstudiante> historialTopicoPorFechasAnual(String fechaini, String fechafin);
	public abstract List<TopicoEstudiante> historialTopicoPorFechasSemanal(String fechaini, String fechafin);
	public abstract List<TopicoEstudiante> historialTopicoPorFechas(String fechaini, String fechafin);



}
