package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Nivelgrado;

public interface UbigeoService {
	

	public abstract List<String> listaDepartamentos();
	public abstract List<String> listaProvincias(String departamento);
	public abstract List<Nivelgrado> listaDistritos(String departamento,String provincia);

}
