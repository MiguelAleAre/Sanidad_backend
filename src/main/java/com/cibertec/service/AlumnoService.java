package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Alumno;

public interface AlumnoService {

	public abstract List<Alumno> listaTodos();
	public abstract Alumno insertar(Alumno obj);
}
