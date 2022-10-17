package com.cibertec.controller;

/**
 * @author CAMILA FLORES
 * */

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

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Libro;
import com.cibertec.service.LibroService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/libro")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class LibroController {
	
	@Autowired
	public LibroService libroService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Libro>> listaLibro(){
		List<Libro> lista = libroService.listaLibro();
		return ResponseEntity.ok(lista);
	}
	
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> inserta(@Valid @RequestBody Libro obj, Errors errors){
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
		
		try {
			obj.setIdLibro(0);
			obj.setFechaRegistro(new Date());
			obj.setEstado(1);
			Libro objSalida = libroService.insertaActualizaLibro(obj);
			if (objSalida == null) {
				lstMensajes.add("Error en el registro");
			} else {
				lstMensajes.add("Se registró exitosamente el libro con el ID ==> " + objSalida.getIdLibro());
			}
		} catch (Exception e) {
			
			salida.put("errores", lstMensajes);
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/porFiltro")
	@ResponseBody
	public ResponseEntity<List<Libro>> listaLibroPorFiltro(
				@RequestParam(name = "titulo", required = false, defaultValue = "" )String titulo, 
				//@RequestParam(name = "anio" , required = false, defaultValue = "2022" ) String anio,
				@RequestParam(name = "idCategoria" , required = false, defaultValue = "-1" ) int idCategoria) {
		
		/*int anios = 0;
		anios=Integer.parseInt(anio);*/
		
		List<Libro> lista = libroService.listaLibro("%"+titulo+"%",idCategoria);	
		

		return ResponseEntity.ok(lista);
	}

}
