package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.TopicoAuxiliar;


public interface TopicoAuxiliarService {
	
	public abstract List<TopicoAuxiliar> listaTodosTopicoAuxiliar();
	public abstract TopicoAuxiliar insertarTopicoAuxiliar(TopicoAuxiliar obj);
	public abstract List<TopicoAuxiliar> listaAuxiliarPorIncidenteLike(String incidente);
	public abstract List<TopicoAuxiliar> buscaHistorialAuxiliar(int idAuxiliar);
	public abstract List<TopicoAuxiliar> historialTopicoPorFechasMensual(String fechaini, String fechafin);
	public abstract List<TopicoAuxiliar> historialTopicoPorFechasAnual(String fechaini, String fechafin);
	public abstract List<TopicoAuxiliar> historialTopicoPorFechasSemanal(String fechaini, String fechafin);
	public abstract List<TopicoAuxiliar> historialTopicoPorFechas(String fechaini, String fechafin);

}
