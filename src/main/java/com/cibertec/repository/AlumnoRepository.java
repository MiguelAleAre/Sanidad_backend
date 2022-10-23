package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	@Query("select x from Alumno x where (?1 is '' or x.nombres like ?1) and (?2 is '' or x.dni = ?2) and (?3 is '' or x.correo like ?3) and x.estado = ?4 and  (?5 is -1 or x.pais.idPais = ?5)")      
	public List<Alumno> listaAlumnoPorNombresDniCorreoEstadoPais(String nombre, String dni, String correo, int estado, int pais);
	
}


