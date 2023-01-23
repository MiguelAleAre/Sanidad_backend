package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entity.Vacuna_has_Vacunacion;
import com.cibertec.entity.Vacunacion;

public interface VacunacionService {
	public abstract Vacunacion insertaVacunacion(Vacunacion bean);
	public abstract List<Vacunacion> listaVacunacion(int idEstudiante);
	public abstract Optional<Vacunacion> listaVacunacionPorId(int idVacunacion);
	public abstract List<Vacuna_has_Vacunacion> listaDetalle(int idVacunacion);
	
}
