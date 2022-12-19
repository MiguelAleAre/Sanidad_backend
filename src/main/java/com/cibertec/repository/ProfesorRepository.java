package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cibertec.entity.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor,Integer>{
	
	@Query("select x from Profesor x where x.dni like ?1")
	public List<Profesor> listaProfesorPorDniLike(String dni);
	

}
