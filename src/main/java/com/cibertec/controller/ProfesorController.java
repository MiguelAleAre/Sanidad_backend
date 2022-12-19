package com.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Profesor;
import com.cibertec.service.ProfesorService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/profesor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProfesorController {
	
	@Autowired
	private ProfesorService proService;

	@GetMapping("/listaProfesorPorDniLike/{dni}")
	@ResponseBody
	public ResponseEntity<List<Profesor>> listaProfesorPorDniLike(@PathVariable("dni") String dni) {
		List<Profesor> lista  = null;
		try {
			if (dni.equals("todos")) {
				lista = proService.listaProfesorPorDniLike("%");
			}else {
				lista = proService.listaProfesorPorDniLike("%" + dni + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraProfesor")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaProfesor(@RequestBody Profesor obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
		
			Profesor objSalida =  proService.insertaActualizaProfesor(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Registro incorrecto");
			} else {
				salida.put("mensaje", "Se registro correctamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Registro incorrecto");
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizaProfesor")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaProfesor(@RequestBody Profesor obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Profesor objSalida = proService.insertaActualizaProfesor(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se actualizo de manera correcta");
			} else {
				salida.put("mensaje", "Se actualizo correctamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se actualizo de manera correcta");
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@DeleteMapping("/eliminaProfesor/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaProfesor(@PathVariable("id") int idProfesor) {
		Map<String, Object> salida = new HashMap<>();
		try {
			proService.eliminaProfesores(idProfesor);
			salida.put("mensaje", "Se elimino correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se elimino de la manera correcta");
		}
		return ResponseEntity.ok(salida);
	}
}
