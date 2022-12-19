package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.TopicoProfesor;

public interface TopicoProfesorRepository extends JpaRepository<TopicoProfesor, Integer> {
	
	@Query("select x from TopicoProfesor x where x.incidente like ?1")
	public List<TopicoProfesor> listaTopicoProfePorIncidenteLike(String incidente);
	
	@Query("select x from TopicoProfesor x where x.profesor.idProfesor like ?1")
	public List<TopicoProfesor> historialProfePorId(int idAuxiliar);
}