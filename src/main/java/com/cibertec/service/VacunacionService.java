package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entity.TopicoEstudiante;
import com.cibertec.entity.Vacunacion;

public interface VacunacionService {
	public abstract Vacunacion insertaEjemplo1(Vacunacion bean);
	public abstract Vacunacion insertaEjemplo2(Vacunacion bean);
	public abstract Vacunacion insertaEjemplo3(Vacunacion bean);
	public abstract List<Vacunacion> listaVacunacion(int idEstudiante);
	public abstract Optional<Vacunacion> listaVacunacionPorId(int idVacunacion);
	public abstract List<Vacunacion> historialVacunasPorFechasMensual(String fechaini, String fechafin);
	public abstract List<Vacunacion> historialVacunasPorFechasAnual(String fechaini, String fechafin);
	public abstract List<Vacunacion> historialVacunasPorFechasSemanal(String fechaini, String fechafin);
	public abstract List<Vacunacion> historialVacunasPorFechas(String fechaini, String fechafin,String Vacunaz);
	public abstract List<Vacunacion> historialVacunasPorNombre1(String nombre);
	public abstract List<Vacunacion> historialVacunasPorNombre2(String nombre);
}
