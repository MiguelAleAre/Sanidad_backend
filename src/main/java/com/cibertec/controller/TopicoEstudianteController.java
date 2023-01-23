package com.cibertec.controller;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.util.AppSettings;
import com.cibertec.service.TopicoEstudianteService;
import com.cibertec.entity.Sala;
import com.cibertec.entity.TopicoEstudiante;


@RestController
@RequestMapping("/url/topicoestudiante")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class TopicoEstudianteController {
	
	@Autowired
	private TopicoEstudianteService topicoestu;


	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<TopicoEstudiante>> listaEstudiante(){
		List<TopicoEstudiante> lista = topicoestu.listaTodosTopicoEstudiante();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaTopicoEstudiantePorIncidenteLike/{inci}")
	@ResponseBody
	public ResponseEntity<List<TopicoEstudiante>> listaTopicoEstuPorIncidenteLike(@PathVariable("inci") String inci) {
		List<TopicoEstudiante> lista  = null;
		try {
			if (inci.equals("todos")) {
				lista = topicoestu.listaEstudiantePorIncidenteLike("%");
			}else {
				lista = topicoestu.listaEstudiantePorIncidenteLike("%" + inci + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/historialEstudiantePorId/{idEstudiante}")
	@ResponseBody
	public ResponseEntity<List<TopicoEstudiante>> historialEstudiantePorId(@PathVariable("idEstudiante") int idEstudiante) {
		List<TopicoEstudiante> lista  = null;
		try {
		
				lista = topicoestu.buscaHistorialAlumno(idEstudiante);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraTopicoEstudiantes")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaEstudiante(@RequestBody TopicoEstudiante obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			//obj.setIdTopicoestu(0);
			
			Calendar dias = Calendar.getInstance();
			dias.setTime(new Date());
			dias.add(Calendar.HOUR, 7);
			
			obj.setFechaRegistro(dias.getTime());
			
			TopicoEstudiante objSalida =  topicoestu.insertarTopicoEstudiante(obj);
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
	
	
	@GetMapping("/historialTopicoFechas")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> historialTopicoFechas(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "01-01-1900") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "01-01-2100") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<TopicoEstudiante> lista = topicoestu.historialTopicoPorFechas(fechaInicio, fechaFin);
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
	
	@GetMapping("/historialTopicoFechasAnual")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> historialTopicoFechasAnual(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "01-01-1900") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "01-01-2100") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<TopicoEstudiante> lista = topicoestu.historialTopicoPorFechas(fechaInicio, fechaFin);
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
	
	@GetMapping("/historialTopicoFechasMensual")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> historialTopicoFechasMensual(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "01-01-1900") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "01-01-2100") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<TopicoEstudiante> lista = topicoestu.historialTopicoPorFechas(fechaInicio, fechaFin);
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
	
	@GetMapping("/historialTopicoFechasSemanal")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> historialTopicoFechasSemanal(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "01-01-1900") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "01-01-2100") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<TopicoEstudiante> lista = topicoestu.historialTopicoPorFechas(fechaInicio, fechaFin);
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