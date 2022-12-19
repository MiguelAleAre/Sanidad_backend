package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Servicio;
import com.cibertec.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService{
	
	
	@Autowired
	ServicioRepository repository;

	@Override
	public Servicio insertaActualizaServicio(Servicio servicio) {
		return repository.save(servicio);
	}

	@Override
	public List<Servicio> listaServicioPorDniLike(String dni) {
		return repository.listaServicioPorDniLike(dni);
	}

	@Override
	public void eliminaServicios(int idServicio) {
		repository.deleteById(idServicio);
		
	}

}
