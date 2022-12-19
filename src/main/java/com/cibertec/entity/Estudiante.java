package com.cibertec.entity;

import java.util.Date;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "estudiante")
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstudiante;
	
	private String nombrediante;
	
	private String apellidodiante;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsexo")
	private Sexo sexo;
	
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "America/Lima")
	private Date fecha_nac;
	
	private String dni;
	
	private String nrseriepa;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcondicion")
	private Condicion condicion;
	
	private String direccion;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idNivelgrado")
	private Nivelgrado nivelgrado;
	
	private int estado;

    
	
	

	public String getNombrediante() {
		return nombrediante;
	}

	public void setNombrediante(String nombre) {
		this.nombrediante = nombre;
	}

	public String getApellidodiante() {
		return apellidodiante;
	}

	public void setApellidodiante(String apellido) {
		this.apellidodiante = apellido;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNrseriepa() {
		return nrseriepa;
	}

	public void setNrseriepa(String nrseriepa) {
		this.nrseriepa = nrseriepa;
	}

	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public Nivelgrado getNivelgrado() {
		return nivelgrado;
	}

	public void setNivelgrado(Nivelgrado nivelgrado) {
		this.nivelgrado = nivelgrado;
	}
	
	
	
	
	
	
	
	
	

}
