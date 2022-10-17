package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.Libro;


public interface LibroRepository extends JpaRepository<Libro, Integer>{
	//and (?2 is '' or e.anio = ?2 ) 
	@Query("select e from Libro e where (e.titulo like ?1) and (?2 is -1 or e.categoria.idCategoria = ?2)")
	public abstract List<Libro> listaLibro(String titulo, int idCategoria);
	

}
