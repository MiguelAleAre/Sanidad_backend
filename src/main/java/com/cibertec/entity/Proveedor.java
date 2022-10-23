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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProveedor;
	@Pattern(regexp = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,100}" , message = "La razon social es de 2 a 100 caracteres ")
	private String razonsocial;
	@Pattern(regexp = "[0-9]{11}" ,message = "El ruc tiene 11 dígitos ")
	private String ruc;
	private String direccion;
	@Pattern(regexp = "[0-9]{9}" ,message = "El # de celular tiene 9 dígitos ")
	private String celular;
	@Pattern(regexp = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,200}" , message = "El contacto es de 2 a 200 caracteres ")
	private String contacto;
	private int estado;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaRegistro;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPais")
	private Pais pais;
}
