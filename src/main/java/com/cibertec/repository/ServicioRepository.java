package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cibertec.entity.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio,Integer>{
	
	@Query("select x from Servicio x where x.dni like ?1")
	public List<Servicio> listaServicioPorDniLike(String dni);
	

}
