package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Autor;

public interface AutorService {

	public abstract Autor insertaAutor(Autor obj);
	
	public abstract List<Autor> listaAutorporParametros(String nombres, String estado, int idGrado, String fechInicio, String fechFin);
}
