package com.cibertec.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nivelgrado")
public class Nivelgrado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNivelgrado;
	private String nivel;
	private String grado;
	private String seccion;
	
	public int getIdNivelgrado() {
		return idNivelgrado;
	}
	public void setIdNivelgrado(int idNivelgrado) {
		this.idNivelgrado = idNivelgrado;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	

	
	
}


