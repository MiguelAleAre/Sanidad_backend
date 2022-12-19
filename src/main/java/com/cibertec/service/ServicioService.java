package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Servicio;

public interface ServicioService {
	
	 public abstract Servicio insertaActualizaServicio(Servicio servicio);
		public abstract List<Servicio> listaServicioPorDniLike(String dni);
		public abstract void eliminaServicios(int idServicio);

}
