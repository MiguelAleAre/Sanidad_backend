package com.cibertec.service;

import java.util.List;


import com.cibertec.entity.Estudiante;

public interface EstudianteService {
	
     List<Estudiante> listaTodos();
    public abstract Estudiante insertaActualizaEstudiante(Estudiante estudiante);
	public abstract List<Estudiante> listaEstudiantePorNombreLike(String nombre);
	public abstract void eliminaEstudiantes(int idEstudiante);

}
