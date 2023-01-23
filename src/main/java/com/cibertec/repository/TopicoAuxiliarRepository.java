package com.cibertec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.Sala;
import com.cibertec.entity.TopicoAuxiliar;

public interface TopicoAuxiliarRepository extends JpaRepository<TopicoAuxiliar, Integer> {
	
	@Query("select x from TopicoAuxiliar x where x.incidente like ?1")
	public List<TopicoAuxiliar> listaTopicoAuxiPorIncidenteLike(String incidente);
	
	@Query("select x from TopicoAuxiliar x where x.auxiliar.idAuxiliar like ?1")
	public List<TopicoAuxiliar> historialAuxiliarPorId(int idAuxiliar);
	

}