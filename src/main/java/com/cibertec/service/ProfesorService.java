package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Profesor;

public interface ProfesorService {
	
	 public abstract Profesor insertaActualizaProfesor(Profesor profesor);
		public abstract List<Profesor> listaProfesorPorDniLike(String dni);
		public abstract void eliminaProfesores(int idProfesor);

}
