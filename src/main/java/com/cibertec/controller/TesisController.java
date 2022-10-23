package com.cibertec.controller;

import java.util.ArrayList;
import java.util.Calendar;
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

import com.cibertec.entity.Tesis;
import com.cibertec.service.TesisService;
import com.cibertec.util.AppSettings;

/**
 * @author Jorge
 */

@RestController
@RequestMapping("/url/tesis")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class TesisController {
	
	@Autowired
	private TesisService tesisService;
	
	@GetMapping("/listaTesisConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaTesisConParametros(
			@RequestParam(name = "titulo", required = false, defaultValue = "") String titulo,
			@RequestParam(name = "tema", required = false, defaultValue = "") String tema,
			@RequestParam(name = "estado", required = true, defaultValue = "1") int estado,
			@RequestParam(name = "alumno", required = false, defaultValue = "") int alumno
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Tesis> lista = tesisService.listaTesisConParametrosTituloTemaEstadoAlumno("%"+titulo+"%", "%"+tema+"%", estado, alumno);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No hay datos");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size() + " elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Ocurrió un error");
		}
		return ResponseEntity.ok(salida);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> inserta(@Valid @RequestBody Tesis obj, Errors errors) {
		HashMap<String, Object> salida = new HashMap<>();
		List<String> lstMensajes = new ArrayList<String>();
		salida.put("errores", lstMensajes);

		List<ObjectError> lstErrors = errors.getAllErrors();
		for (ObjectError objectError : lstErrors) {
			objectError.getDefaultMessage();
			lstMensajes.add(objectError.getDefaultMessage());
		}

		if (!CollectionUtils.isEmpty(lstMensajes)) {
			return ResponseEntity.ok(salida);
		}
		obj.setFechaRegistro(Calendar.getInstance().getTime());
		obj.setEstado(1);
		Tesis objSalida = tesisService.insertaActualizaTesis(obj);
		if (objSalida == null) {
			lstMensajes.add("Error al registrar");
		} else {
			lstMensajes.add("Se registro la Tesis con el ID ==> " + objSalida.getIdTesis());
		}
		return ResponseEntity.ok(salida);
	}
}
