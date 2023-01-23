package com.cibertec.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Vacuna_has_VacunacionPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name ="idVacunacion", unique = true, nullable = false, length = 10, insertable = true, updatable = false)
	private int idVacunacion;
	
	@Column(name = "idVacuna", unique = true, nullable = false, length = 10, insertable = true, updatable = false)
	private int idVacuna;
}
