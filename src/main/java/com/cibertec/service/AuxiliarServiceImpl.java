package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Auxiliar;
import com.cibertec.repository.AuxiliarRepository;

@Service
public class AuxiliarServiceImpl implements AuxiliarService {
	
	@Autowired
	AuxiliarRepository repository;

	@Override
	public Auxiliar insertaActualizaAuxiliar(Auxiliar auxiliar) {
		return repository.save(auxiliar);
	}

	@Override
	public List<Auxiliar> listaAuxiliarPorDniLike(String dni) {
		return repository.listaAuxiliarPorDniLike(dni);
	}

	@Override
	public void eliminaAuxiliares(int idAuxiliar) {
		repository.deleteById(idAuxiliar);
	}

	
	
}
