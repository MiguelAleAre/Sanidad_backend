package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
	@Query("select distinct x.descripcion from Categoria x order by 1 asc")
	public abstract List<String> listaCategorias();

}
