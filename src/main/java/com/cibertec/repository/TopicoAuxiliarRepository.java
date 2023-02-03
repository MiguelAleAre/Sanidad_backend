package com.cibertec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cibertec.entity.TopicoAuxiliar;


public interface TopicoAuxiliarRepository extends JpaRepository<TopicoAuxiliar, Integer> {
	
	@Query("select x from TopicoAuxiliar x where x.incidente like ?1")
	public List<TopicoAuxiliar> listaTopicoAuxiPorIncidenteLike(String incidente);
	
	@Query("select x from TopicoAuxiliar x where x.auxiliar.idAuxiliar like ?1")
	public List<TopicoAuxiliar> historialAuxiliarPorId(int idAuxiliar);
	
	@Query("select x from TopicoAuxiliar x where (x.fechaRegistro between ?1  and ?2 )")
	public List<TopicoAuxiliar> historialTopicoPorFechas(Date fechaini, Date fechafin);
	
	@Query("select x from TopicoAuxiliar x where (x.fechaRegistro between ?1  and ?2 )")
	public void registroTopicoAuxiliar(int idAuxiliar);

}