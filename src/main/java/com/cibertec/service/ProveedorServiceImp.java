package com.cibertec.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Proveedor;
import com.cibertec.repository.ProveedorRepository;

@Service
public class ProveedorServiceImp implements ProveedorService {

	@Autowired
	ProveedorRepository repo;
	
	@Override
	public Proveedor insertaActualizaPrueba(Proveedor obj) {
		return repo.save(obj);
	}

}
