package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Auxiliar;

public interface AuxiliarService {
	
	public abstract Auxiliar insertaActualizaAuxiliar(Auxiliar auxiliar);
	public abstract List<Auxiliar> listaAuxiliarPorDniLike(String dni);
	public abstract void eliminaAuxiliares(int idAuxiliar);

}
