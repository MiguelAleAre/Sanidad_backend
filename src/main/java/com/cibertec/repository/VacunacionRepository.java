package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.Vacunacion;

public interface VacunacionRepository extends JpaRepository<Vacunacion, Integer>{
	
	@Query("select p from Vacunacion p where p.estudiante.idEstudiante = ?1")
	public abstract List<Vacunacion> listaVacunacion(int idEstudiante);

}
