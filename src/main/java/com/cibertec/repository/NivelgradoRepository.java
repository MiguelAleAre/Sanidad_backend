package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Nivelgrado;

public interface NivelgradoRepository extends JpaRepository<Nivelgrado, Integer>{

	
	@Query("select distinct x.nivel from Nivelgrado x order by 1 asc")
	public abstract List<String> listaDepartamentos();
	
	@Query("select distinct x.grado from Nivelgrado x where x.nivel = :var_dep  order by 1 asc")
	public abstract List<String> listaProvincias(@Param("var_dep") String departamento);  

	@Query("select x from Nivelgrado x where x.nivel = :var_dep and x.grado = :var_pro  order by x.seccion asc")
	public abstract List<Nivelgrado> listaDistritos(@Param("var_dep") String departamento,@Param("var_pro") String provincia);
	
	
}
