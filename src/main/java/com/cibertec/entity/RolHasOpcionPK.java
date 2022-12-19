package com.cibertec.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode
@Embeddable
public class RolHasOpcionPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idRol;
	private int idOpcion;
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public int getIdOpcion() {
		return idOpcion;
	}
	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
