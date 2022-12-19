package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.TopicoAuxiliar;

public interface TopicoAuxiliarService {
	
	public abstract List<TopicoAuxiliar> listaTodosTopicoAuxiliar();
	public abstract TopicoAuxiliar insertarTopicoAuxiliar(TopicoAuxiliar obj);
	public abstract List<TopicoAuxiliar> listaAuxiliarPorIncidenteLike(String incidente);
	public abstract List<TopicoAuxiliar> historialAuxiliarPorId(int idAuxiliar);

}
