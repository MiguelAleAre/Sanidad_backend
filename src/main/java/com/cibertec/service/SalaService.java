package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Sala;


public interface SalaService {

	public abstract List<Sala> listaTodos();
	public Sala insertaSala(Sala obj);
	public abstract List<Sala>listaSalaPorCampos(String numero,String recursos, String fecInicio, String fecFin,int estado,int idSede);
	

}
