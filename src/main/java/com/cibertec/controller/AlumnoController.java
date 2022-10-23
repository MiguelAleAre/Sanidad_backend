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

import com.cibertec.entity.Alumno;
import com.cibertec.service.AlumnoService;
import com.cibertec.util.AppSettings;

/**
 * @author richa
 */
@RestController
@RequestMapping("/url/alumno")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("/listaAlumnoConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaAlumnoNombreDniUbigeo(
			@RequestParam(name = "nombre", required = false, defaultValue = "") String nombre,
			@RequestParam(name = "dni", required = false, defaultValue = "") String dni,
			@RequestParam(name = "correo", required = false, defaultValue = "") String correo,
			@RequestParam(name = "estado", required = true, defaultValue = "1") int estado,
			@RequestParam(name = "pais", required = false, defaultValue = "") int pais
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Alumno> lista = alumnoService.listaAlumnoPorNombresDniCorreoEstadoPais("%"+nombre+"%", dni, "%"+correo+"%", estado, pais);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size() + " elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Ocurrio un Error");
		}
		return ResponseEntity.ok(salida);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> inserta(@Valid @RequestBody Alumno obj, Errors errors) {
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
		Alumno objSalida = alumnoService.insertar(obj);
		if (objSalida == null) {
			lstMensajes.add("Error en el registro");
		} else {
			lstMensajes.add("Se registró la Alumno con el ID ==> " + objSalida.getIdAlumno());
		}
		return ResponseEntity.ok(salida);
	}
}
