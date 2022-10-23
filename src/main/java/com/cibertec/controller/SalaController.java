package com.cibertec.controller;

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

import com.cibertec.util.AppSettings;
import com.cibertec.entity.Sala;
import com.cibertec.service.SalaService;
/**

 * @author MIGUEL AREVALO

 * 

 */
@RestController
@RequestMapping("/url/sala")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class SalaController {
	
	@Autowired
	private SalaService salaService;

	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Sala>> listaSala(){
		List<Sala> lista = salaService.listaTodos();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public  ResponseEntity<?> insertaSala(@Valid @RequestBody Sala obj, Errors errors){
		Map<String, Object> salida = new HashMap<>();
		List<String> lstMensajes = new ArrayList<>();
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
			obj.setFechaRegistro(new Date());
			obj.setEstado(1);
		    Sala objSalida = salaService.insertaSala(obj);
			if (objSalida == null) {
				lstMensajes.add("No se pudo registrar correctamente");
			} else {
				lstMensajes.add("Se registró la sala con el ID ==> " + objSalida.getIdSala());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/listaSalaPorCampos")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaDocenteNombreDniUbigeo(
			@RequestParam(name = "numero", required = false, defaultValue = "") String numero,
			@RequestParam(name = "recursos", required = true, defaultValue = "") String recursos,
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "9999-01-01") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "9999-01-01") String fechaFin,
			@RequestParam(name = "estado", required = false, defaultValue = "1") int estado,
			@RequestParam(name = "idSede", required = false, defaultValue = "-1") int idSede
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Sala> lista = salaService.listaSalaPorCampos("%"+numero+"%","%"+recursos+"%",fechaInicio, fechaFin,estado,idSede);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No hay datos disponibles con esas caracteristicas");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size() + " elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}
	
	

}
