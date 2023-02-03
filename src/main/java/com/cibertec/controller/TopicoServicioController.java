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

import com.cibertec.entity.TopicoEstudiante;
import com.cibertec.entity.TopicoServicio;
import com.cibertec.service.TopicoServicioService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/topicoservicio")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class TopicoServicioController {
	
	@Autowired
	private TopicoServicioService topicoser;


	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<TopicoServicio>> listaServicioTopico(){
		List<TopicoServicio> lista = topicoser.listaTodosTopicoServicio();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaTopicoServicioPorIncidenteLike/{inci}")
	@ResponseBody
	public ResponseEntity<List<TopicoServicio>> listaTopicoServicioPorIncidenteLike(@PathVariable("inci") String inci) {
		List<TopicoServicio> lista  = null;
		try {
			if (inci.equals("todos")) {
				lista = topicoser.listaServicioPorIncidenteLike("%");
			}else {
				lista = topicoser.listaServicioPorIncidenteLike("%" + inci + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/historialServicioPorId/{idEstudiante}")
	@ResponseBody
	public ResponseEntity<List<TopicoServicio>> historialServicioPorId(@PathVariable("idEstudiante") int idEstudiante) {
		List<TopicoServicio> lista  = null;
		try {
		
				lista = topicoser.buscaHistorialServicio(idEstudiante);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraTopicoServicios")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaServicio(@RequestBody TopicoServicio obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			//obj.setIdTopicoestu(0);
			
			Calendar dias = Calendar.getInstance();
			dias.setTime(new Date());
			dias.add(Calendar.HOUR, 7);
			
			obj.setFechaRegistro(dias.getTime());
			
			TopicoServicio objSalida =  topicoser.insertarTopicoServicio(obj);
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
	public ResponseEntity<Map<String, Object>> historialTopicoFechasSer(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "1900-01-01") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "2100-01-01") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<TopicoServicio> lista = topicoser.historialTopicoPorFechas(fechaInicio, fechaFin);
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
	public ResponseEntity<Map<String, Object>> historialTopicoFechasAnualSer(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "1900-01-01") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "2100-01-01") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<TopicoServicio> lista = topicoser.historialTopicoPorFechasAnual(fechaInicio, fechaFin);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No hay datos registrados el ultimo año");
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
	public ResponseEntity<Map<String, Object>> historialTopicoFechasMensualSer(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "1900-01-01") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "2100-01-01") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<TopicoServicio> lista = topicoser.historialTopicoPorFechasMensual(fechaInicio, fechaFin);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No hay datos registrados el ultimo mes");
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
	public ResponseEntity<Map<String, Object>> historialTopicoFechasSemanalSer(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "1900-01-01") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "2100-01-01") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<TopicoServicio> lista = topicoser.historialTopicoPorFechasSemanal(fechaInicio, fechaFin);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No hay datos registrados la ultima semana");
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
