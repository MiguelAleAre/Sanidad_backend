package com.cibertec.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tesis")
@AllArgsConstructor
@NoArgsConstructor
public class Tesis {
  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTesis;
	@Pattern(regexp = "[a-zA-Z0-9áéíóúñüÁÉÍÓÚÑÜ\\s]{0,200}" , message = "El titulo es hasta 200 caracteres")
	private String titulo;
	@Pattern(regexp = "[a-zA-Z0-9áéíóúñüÁÉÍÓÚÑÜ\\s]{0,200}" , message = "El tema es hasta 200 caracteres")
	private String tema;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "America/Lima")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaRegistro;

	private int estado;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAlumno")
	private Alumno alumno;
	

   
}
