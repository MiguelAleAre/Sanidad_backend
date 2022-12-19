package com.cibertec.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Vacuna;
import com.cibertec.repository.VacunaRepository;
@Service
public class VacunaServiceImpl implements VacunaService {

	@Autowired
	VacunaRepository repository;
	
	
	@Override
	public List<Vacuna> listaVacunas() {
		return repository.findAll();
	}

}
