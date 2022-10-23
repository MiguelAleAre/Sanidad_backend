package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.Sala;


public interface SalaRepository extends JpaRepository<Sala, Integer>{
	
	@Query("select x from Sala x where (?1 is ' ' or x.numero like ?1) and (?2 is '' or x.recursos like ?2) and (?3 is '9999-01-01' or ?4 is '9999-01-01' or (x.fechaRegistro between ?3  and ?4 )) and (x.estado = ?5) and (?6 is -1 or x.sede.idSede = ?6)")
	public List<Sala> listaSalaPorCampos(String numero,String recursos, String fecInicio, String fecFin,int estado,int idSede);
	
	//Codigo creado por Miguel Arevalo Arias	

}