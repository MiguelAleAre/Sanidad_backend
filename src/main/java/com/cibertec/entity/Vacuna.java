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
@Table(name = "Vacuna")
public class Vacuna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVacuna;
	private String Vacuna;
}