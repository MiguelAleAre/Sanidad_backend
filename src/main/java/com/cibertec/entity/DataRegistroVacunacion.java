package com.cibertec.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataRegistroVacunacion {
	private Estudiante estudiante;
	private List<Seleccion> seleccionados;
}
