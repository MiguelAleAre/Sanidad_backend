package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.Tesis;

public interface TesisRepository extends JpaRepository<Tesis, Integer>{
	
	@Query("select t from Tesis t where (?1 is '' or t.titulo like ?1) and (?2 is '' or t.tema like ?2) and (t.estado = ?3) and (?4 is -1 or t.alumno.idAlumno = ?4)")
	public List<Tesis> listaTesisConParametrosTituloTemaEstadoAlumno(String titulo, String tema, int estado, int alumno);

}
