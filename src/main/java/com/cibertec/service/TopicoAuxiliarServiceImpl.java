package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.TopicoAuxiliar;
import com.cibertec.repository.TopicoAuxiliarRepository;

@Service
public class TopicoAuxiliarServiceImpl implements TopicoAuxiliarService{
	
	@Autowired
	private TopicoAuxiliarRepository repository;

	@Override
	public List<TopicoAuxiliar> listaTodosTopicoAuxiliar() {
		return repository.findAll();
	}

	@Override
	public TopicoAuxiliar insertarTopicoAuxiliar(TopicoAuxiliar obj) {
		return repository.save(obj);
	}

	@Override
	public List<TopicoAuxiliar> listaAuxiliarPorIncidenteLike(String incidente) {
		return repository.listaTopicoAuxiPorIncidenteLike(incidente);
	}

	@Override
	public List<TopicoAuxiliar> historialAuxiliarPorId(int idAuxiliar) {
		return repository.historialAuxiliarPorId(idAuxiliar);
	}

}
