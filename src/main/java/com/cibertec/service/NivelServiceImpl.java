package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Nivel;
import com.cibertec.repository.NivelRepository;

@Service
public class NivelServiceImpl implements NivelService{
	
	@Autowired
	NivelRepository repository;

	@Override
	public List<Nivel> listaTodos() {
		return repository.findAll();
		}

}
