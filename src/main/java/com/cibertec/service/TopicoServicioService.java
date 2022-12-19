package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.TopicoServicio;

public interface TopicoServicioService {
	
	public abstract List<TopicoServicio> listaTodosTopicoServicio();
	public abstract TopicoServicio insertarTopicoServicio(TopicoServicio obj);
	public abstract List<TopicoServicio> listaServicioPorIncidenteLike(String incidente);
	public abstract List<TopicoServicio> historialServicioPorId(int idServicio);

}
