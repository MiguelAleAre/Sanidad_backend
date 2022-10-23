package com.cibertec.controller;

/**

 * @author ANDRES GALLEGOS LUQUE

 * 

 */


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


import com.cibertec.entity.Autor;
import com.cibertec.service.AutorService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/autor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AutorController {
	
	@Autowired
	private AutorService autorService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> inserta(@Valid @RequestBody Autor obj, Errors errors){
		
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
			Autor objSalida = autorService.insertaAutor(obj);
			if (objSalida == null) {
				lstMensajes.add("Error en el registro");
			}else {
				lstMensajes.add("Se registró el autor con el ID ==> " + objSalida.getIdAutor());
			}
		
			
			
			
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/listaAutorConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaDocenteNombreDniUbigeo(
			@RequestParam(name = "nombres", required = false, defaultValue = "") String nombres,
			@RequestParam(name = "estado", required = true, defaultValue = "1") String estado,
			@RequestParam(name = "idGrado", required = false, defaultValue = "-1") int idGrado,
			@RequestParam(name = "fechInicio", required = false, defaultValue = "9999-01-01") String fechInicio,			
			@RequestParam(name = "fechFin", required = false, defaultValue = "9999-01-01") String fechFin) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Autor> lista = autorService.listaAutorporParametros("%"+nombres+"%", estado, idGrado, fechInicio, fechFin);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size() + " elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}

}
