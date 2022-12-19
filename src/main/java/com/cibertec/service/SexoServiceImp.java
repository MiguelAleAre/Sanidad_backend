package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Sexo;
import com.cibertec.repository.SexoRepository;

@Service
public class SexoServiceImp implements SexoService {

	
	@Autowired
	SexoRepository Repository;
	
	@Override
	public List<Sexo> listaTodos() {
		return Repository.findAll();
	}

}
