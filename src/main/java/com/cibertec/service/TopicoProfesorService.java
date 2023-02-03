package com.cibertec.service;

import java.util.List;


import com.cibertec.entity.TopicoProfesor;

public interface TopicoProfesorService {
	
	public abstract List<TopicoProfesor> listaTodosTopicoProfesor();
	public abstract TopicoProfesor insertarTopicoProfesor(TopicoProfesor obj);
	public abstract List<TopicoProfesor> listaProfesorPorIncidenteLike(String incidente);
	public abstract List<TopicoProfesor> buscaHistorialProfesor(int idProfesor);
	public abstract List<TopicoProfesor> historialTopicoPorFechasMensual(String fechaini, String fechafin);
	public abstract List<TopicoProfesor> historialTopicoPorFechasAnual(String fechaini, String fechafin);
	public abstract List<TopicoProfesor> historialTopicoPorFechasSemanal(String fechaini, String fechafin);
	public abstract List<TopicoProfesor> historialTopicoPorFechas(String fechaini, String fechafin);

}
