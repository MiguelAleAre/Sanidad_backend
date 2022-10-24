package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

	@Query("select p from Proveedor p where (p.razonsocial like ?1) and (?2 is '' or p.ruc = ?2) and (p.contacto like ?3) and (?4 is -1 or p.pais.idPais = ?4) and (p.estado = ?5)")      
	public abstract List<Proveedor> listaProveedor(String razSocial, String ruc, String contacto, int idPais, int estado);
}
