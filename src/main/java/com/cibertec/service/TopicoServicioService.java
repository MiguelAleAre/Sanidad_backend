package com.cibertec.service;

import java.util.List;


import com.cibertec.entity.TopicoServicio;

public interface TopicoServicioService {
	
	public abstract List<TopicoServicio> listaTodosTopicoServicio();
	public abstract TopicoServicio insertarTopicoServicio(TopicoServicio obj);
	public abstract List<TopicoServicio> listaServicioPorIncidenteLike(String incidente);
	public abstract List<TopicoServicio> buscaHistorialServicio(int idServicio);
	public abstract List<TopicoServicio> historialTopicoPorFechasMensual(String fechaini, String fechafin);
	public abstract List<TopicoServicio> historialTopicoPorFechasAnual(String fechaini, String fechafin);
	public abstract List<TopicoServicio> historialTopicoPorFechasSemanal(String fechaini, String fechafin);
	public abstract List<TopicoServicio> historialTopicoPorFechas(String fechaini, String fechafin);

}
