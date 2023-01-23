package com.cibertec.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vacunacion_has_vacuna")
public class Vacuna_has_Vacunacion {
	
	@EmbeddedId
	private Vacuna_has_VacunacionPK vacunahasvacunacionPK;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idVacunacion", nullable = false, insertable = false, updatable = false)
	private Vacunacion vacunacion;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idVacuna", nullable = false, insertable = false, updatable = false)
	private Vacuna vacuna;
}
