package com.cibertec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.TopicoEstudiante;
import com.cibertec.entity.Vacunacion;

public interface VacunacionRepository extends JpaRepository<Vacunacion, Integer>{
	
	@Query("select p from Vacunacion p where p.estudiante.idEstudiante = ?1")
	public abstract List<Vacunacion> listaVacunacion(int idEstudiante);

	@Query("select x from Vacunacion x where (x.fechaDosis1 between ?1  and ?2 )")
	public List<Vacunacion> historialVacunaPorFechas(Date fechaini, Date fechafin);
	
	@Query("select x from Vacunacion x where (x.fechaDosis1 between ?1  and ?2 ) and x.Vacunaz=?3")
	public List<Vacunacion> historialVacunaPorFechasEspe(Date fechaini, Date fechafin,String Vacunaz);
	
	@Query("select x from Vacunacion x where x.Vacunaz = ?1")
	public List<Vacunacion> historialVacunaPorNombre(String nombre);
}
