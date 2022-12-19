package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.TopicoServicio;
import com.cibertec.repository.TopicoServicioRepository;

@Service
public class TopicoServicioServiceImpl implements TopicoServicioService{
	
	@Autowired
	TopicoServicioRepository repository;

	@Override
	public List<TopicoServicio> listaTodosTopicoServicio() {
		return repository.findAll();
	}

	@Override
	public TopicoServicio insertarTopicoServicio(TopicoServicio obj) {
		return repository.save(obj);
		}

	@Override
	public List<TopicoServicio> listaServicioPorIncidenteLike(String incidente) {
		return repository.listaTopicoServicioPorIncidenteLike(incidente);
	}

	@Override
	public List<TopicoServicio> historialServicioPorId(int idServicio) {
		return repository.historialServicioPorId(idServicio);
	}

}
