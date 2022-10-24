package com.cibertec.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

/*
 * autor: Adrian Soto Hidalgo
 * */

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Proveedor;
import com.cibertec.entity.Prueba;
import com.cibertec.repository.ProveedorRepository;
import com.cibertec.service.ProveedorService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/proveedor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> inserta(@Valid @RequestBody Proveedor obj, Errors errors){
		HashMap<String, Object> salida = new HashMap<>();
		List<String> lstMensajes = new ArrayList<String>();
		salida.put("errores", lstMensajes);
		
		List<ObjectError> lstErrors =  errors.getAllErrors();
		for (ObjectError objectError : lstErrors) {
			objectError.getDefaultMessage();
			lstMensajes.add(objectError.getDefaultMessage());
		}

		if (!CollectionUtils.isEmpty(lstMensajes)) {
			return ResponseEntity.ok(salida);
		}
		obj.setFechaRegistro(new Date());
		obj.setEstado(1);
		Proveedor objSalida = proveedorService.insertaActualizaPrueba(obj);
		if (objSalida == null) {
			lstMensajes.add("Error en el registro");
		}else {
			lstMensajes.add("Se registró el proveedor con el ID ==> " + objSalida.getIdProveedor());
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/filtrar")
	@ResponseBody
	public ResponseEntity<List<Proveedor>> listaProveedorFiltro(
			@RequestParam(name = "razonsocial", required = false, defaultValue = "" )String razSocial, 
			@RequestParam(name = "ruc" , required = false, defaultValue = "" ) String ruc,
			@RequestParam(name = "contacto", required = false, defaultValue = "" )String contacto,
			@RequestParam(name = "idPais" , required = false, defaultValue = "-1" ) int idUbigeo,
			@RequestParam(name = "estado" , required = false, defaultValue = "-1" ) int estado){
		List<Proveedor> lista = proveedorService.listaProveedor("%"+razSocial+"%", ruc, "%"+contacto+"%", idUbigeo, estado);
		return ResponseEntity.ok(lista);
	} 
}
