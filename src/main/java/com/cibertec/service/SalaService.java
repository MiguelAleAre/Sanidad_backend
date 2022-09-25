package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Sala;


public interface SalaService {

	public abstract List<Sala> listaTodos();
	public Sala insertaSala(Sala obj);
	

}
