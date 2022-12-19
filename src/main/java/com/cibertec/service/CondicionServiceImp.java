package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Condicion;
import com.cibertec.repository.CondicionRepository;

@Service
public class CondicionServiceImp implements CondicionService{
	
	@Autowired 
	CondicionRepository Repository;

	@Override
	public List<Condicion> listaTodos() {
		return Repository.findAll();
		}

	

}
