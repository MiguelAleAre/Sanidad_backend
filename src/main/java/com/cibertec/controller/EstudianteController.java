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

import com.cibertec.util.AppSettings;
import com.cibertec.entity.Estudiante;
import com.cibertec.service.EstudianteService;

@RestController
@RequestMapping("/url/estudiante")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EstudianteController {
	
	@Autowired
	private EstudianteService estuService;

	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Estudiante>> listaEstudiante(){
		List<Estudiante> lista = estuService.listaTodos();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/listaEstudiantePorNombreLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Estudiante>> listaEstudiantePorNombreLike(@PathVariable("nom") String nom) {
		List<Estudiante> lista  = null;
		try {
			if (nom.equals("todos")) {
				lista = estuService.listaEstudiantePorNombreLike("%");
			}else {
				lista = estuService.listaEstudiantePorNombreLike("%" + nom + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraEstudiantes")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaEstudiante(@RequestBody Estudiante obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdEstudiante(0);
			obj.setEstado(1);
			Estudiante objSalida =  estuService.insertaActualizaEstudiante(obj);
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

	@PutMapping("/actualizaEstudiante")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaEstudiante(@RequestBody Estudiante obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Estudiante objSalida = estuService.insertaActualizaEstudiante(obj);
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
	
	
	@DeleteMapping("/eliminaEstudiante/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaEstudiante(@PathVariable("id") int idEstudiante) {
		Map<String, Object> salida = new HashMap<>();
		try {
			estuService.eliminaEstudiantes(idEstudiante);
			salida.put("mensaje", "Se elimino correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se elimino de la manera correcta");
		}
		return ResponseEntity.ok(salida);
	}
	
	

	
}
