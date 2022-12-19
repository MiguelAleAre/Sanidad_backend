package com.cibertec.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sexo")
public class Sexo {

	@Id
	private int idsexo;
	
	private String sexo;
	

}
