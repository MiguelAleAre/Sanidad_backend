package com.cibertec.service;


import java.util.List;

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

	@Override
	public List<Proveedor> listaProveedor(String razSocial, String ruc, String contacto, int idPais, int estado) {
		// TODO Auto-generated method stub
		return repo.listaProveedor(razSocial, ruc, contacto, idPais, estado);
	}

}
