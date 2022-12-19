package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.TopicoServicio;

public interface TopicoServicioRepository extends JpaRepository<TopicoServicio, Integer> {
	
	@Query("select x from TopicoServicio x where x.incidente like ?1")
	public List<TopicoServicio> listaTopicoServicioPorIncidenteLike(String incidente);
	
	@Query("select x from TopicoServicio x where x.servicio.idServicio like ?1")
	public List<TopicoServicio> historialServicioPorId(int idAuxiliar);
}