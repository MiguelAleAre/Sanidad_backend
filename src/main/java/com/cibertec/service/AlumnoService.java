package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Alumno;

public interface AlumnoService {

	public abstract List<Alumno> listaTodos();
	public abstract List<Alumno> listaAlumnoPorNombresDniCorreoEstadoPais(String nombre, String dni, String correo, int estado, int pais);
	public abstract Alumno insertar(Alumno obj);
}
