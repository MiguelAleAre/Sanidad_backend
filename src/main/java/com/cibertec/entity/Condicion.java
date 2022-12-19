package com.cibertec.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "condicion")
public class Condicion{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcondicion;
	
	private String condicion;

}
