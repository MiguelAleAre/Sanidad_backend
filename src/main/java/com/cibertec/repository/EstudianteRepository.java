package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cibertec.entity.Estudiante;


public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	

	@Query("select x from Estudiante x where (?1 is ' ' or x.nombrediante like ?1) and (?2 is '' or x.apellidodiante like ?2) and (?3 is '' or x.dni like ?3)")
	public List<Estudiante> listaAlumnoPorDatos(String nombre,String apellido,String dni);
	
	@Query("select x from Estudiante x where x.dni like ?1")
	public List<Estudiante> listaEstudiantePorNombreLike(String nombre);
	
}
