package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.Vacuna_has_Vacunacion;


public interface VacunaHasVacunacionRepository extends JpaRepository<Vacuna_has_Vacunacion, Integer>{
	
	@Query("select pb from Vacuna_has_Vacunacion pb where pb.vacunacion.idVacunacion = ?1")
	public abstract List<Vacuna_has_Vacunacion> listaDetalle(int idPrestamo);

}
