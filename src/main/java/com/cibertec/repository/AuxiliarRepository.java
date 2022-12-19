package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cibertec.entity.Auxiliar;

public interface AuxiliarRepository extends JpaRepository<Auxiliar,Integer>{
	
	@Query("select x from Auxiliar x where x.dni like ?1")
	public List<Auxiliar> listaAuxiliarPorDniLike(String dni);
	

}
