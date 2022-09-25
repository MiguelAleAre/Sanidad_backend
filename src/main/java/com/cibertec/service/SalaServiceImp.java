package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Sala;
import com.cibertec.repository.SalaRepository;

@Service
public class SalaServiceImp implements SalaService {

	@Autowired
	private SalaRepository Repository;

	@Override
	public List<Sala> listaTodos() {
		return Repository.findAll();
	}

	@Override
	public Sala insertaSala(Sala obj) {
		return Repository.save(obj);
	}

}