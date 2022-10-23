package com.cibertec.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer>{

	@Query("select x from Autor x where (?1 is '' or x.nombres like ?1) and (?2 is '' or x.estado = ?2) and (?3 is -1 or x.grado.idGrado = ?3) and (?4 is '9999-01-01' or ?5 is '9999-01-01' or (x.fechaNacimiento between ?4  and ?5 ))")
	public List<Autor> listaAutorporParametros(String nombres, String estado, int idGrado, String fechInicio, String fechFin);
}
