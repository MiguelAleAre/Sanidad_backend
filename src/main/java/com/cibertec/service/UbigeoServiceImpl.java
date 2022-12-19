package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Nivelgrado;
import com.cibertec.repository.NivelgradoRepository;

@Service
public class UbigeoServiceImpl implements UbigeoService {

	@Autowired
	private NivelgradoRepository repository;
	
	@Override
	public List<String> listaDepartamentos() {
		return repository.listaDepartamentos();
	}

	@Override
	public List<String> listaProvincias(String departamento) {
		return repository.listaProvincias(departamento);
	}

	@Override
	public List<Nivelgrado> listaDistritos(String departamento, String provincia) {
		return repository.listaDistritos(departamento, provincia);
	}

}
