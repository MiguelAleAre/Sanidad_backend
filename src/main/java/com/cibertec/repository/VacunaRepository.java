package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cibertec.entity.Vacuna;

public interface VacunaRepository  extends JpaRepository<Vacuna, Integer> {
	
	@Query("select x from Vacuna x where x.vacuna like ?1")
	public List<Vacuna> listaPorVacunaLike(String vacuna);

}
