package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Tesis;

public interface TesisService {
	public abstract List<Tesis> listaTodos();
	public abstract Tesis insertaActualizaTesis(Tesis obj);
	public abstract List<Tesis> listaTesisConParametrosTituloTemaEstadoAlumno(String titulo, String tema, int estado, int alumno);

}
