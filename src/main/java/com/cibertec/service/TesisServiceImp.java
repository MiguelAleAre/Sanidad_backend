package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Tesis;
import com.cibertec.repository.TesisRepository;

@Service
public class TesisServiceImp implements TesisService{
	
	@Autowired
	private TesisRepository repository;

	@Override
	public List<Tesis> listaTodos() {
		return repository.findAll();
	}

	@Override
	public Tesis insertaActualizaTesis(Tesis obj) {
		return repository.save(obj);
	}

	
	
}
