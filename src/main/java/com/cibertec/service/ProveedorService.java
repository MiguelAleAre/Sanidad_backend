package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Proveedor;

public interface ProveedorService {

	public abstract Proveedor insertaActualizaPrueba(Proveedor obj);
	public abstract List<Proveedor> listaProveedor(String nombre, String ruc, int idPais);
}
