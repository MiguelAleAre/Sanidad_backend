package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.Vacuna;

public interface VacunaRepository  extends JpaRepository<Vacuna, Integer> {
	
	@Query("select distinct x.Vacuna from Vacuna x order by 1 asc")
	public abstract List<Vacuna> listaVacunas();

}
