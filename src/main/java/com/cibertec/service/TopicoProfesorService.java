package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.TopicoProfesor;

public interface TopicoProfesorService {
	
	public abstract List<TopicoProfesor> listaTodosTopicoProfesor();
	public abstract TopicoProfesor insertarTopicoProfesor(TopicoProfesor obj);
	public abstract List<TopicoProfesor> listaProfesorPorIncidenteLike(String incidente);
	public abstract List<TopicoProfesor> historialProfesorPorId(int idProfesor);

}
