package com.cibertec.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.TopicoEstudiante;

public interface TopicoEstudianteRepository extends JpaRepository<TopicoEstudiante, Integer> {
	
	@Query("select x from TopicoEstudiante x where x.incidente like ?1")
	public List<TopicoEstudiante> listaTopicoEstuPorIncidenteLike(String incidente);
	
	@Query("select x from TopicoEstudiante x where x.estudiante.idEstudiante like ?1")
	public List<TopicoEstudiante> historialEstudiandoPorId(int idEstudiante);
	
	@Query("select x from TopicoEstudiante x where (x.fechaRegistro between ?1  and ?2 )")
	public List<TopicoEstudiante> historialTopicoPorFechas(Calendar fechaini, Calendar fechafin);
	

}
