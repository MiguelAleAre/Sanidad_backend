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

import com.cibertec.entity.TopicoAuxiliar;
import com.cibertec.entity.TopicoEstudiante;
import com.cibertec.service.TopicoAuxiliarService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/topicoauxiliar")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class TopicoAuxiliarController {
	
	@Autowired
	private TopicoAuxiliarService topicoaux;


	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<TopicoAuxiliar>> listaAuxiliaresTopico(){
		List<TopicoAuxiliar> lista = topicoaux.listaTodosTopicoAuxiliar();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaTopicoAuxiliarPorIncidenteLike/{inci}")
	@ResponseBody
	public ResponseEntity<List<TopicoAuxiliar>> listaTopicoAuxiPorIncidenteLike(@PathVariable("inci") String inci) {
		List<TopicoAuxiliar> lista  = null;
		try {
			if (inci.equals("todos")) {
				lista = topicoaux.listaAuxiliarPorIncidenteLike("%");
			}else {
				lista = topicoaux.listaAuxiliarPorIncidenteLike("%" + inci + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/historialAuxiliarPorId/{idAuxiliar}")
	@ResponseBody
	public ResponseEntity<List<TopicoAuxiliar>> historialAuxiliarPorId(@PathVariable("idAuxiliar") int idAuxiliar) {
		List<TopicoAuxiliar> lista  = null;
		try {
		
				lista = topicoaux.buscaHistorialAuxiliar(idAuxiliar);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraTopicoAuxiliares")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaAuxiliares(@RequestBody TopicoAuxiliar obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			//obj.setIdTopicoestu(0);
			
			Calendar dias = Calendar.getInstance();
			dias.setTime(new Date());
			dias.add(Calendar.HOUR, 7);
			
			obj.setFechaRegistro(dias.getTime());
			
			TopicoAuxiliar objSalida =  topicoaux.insertarTopicoAuxiliar
					(obj);
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
	public ResponseEntity<Map<String, Object>> historialTopicoFechasAux(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "1900-01-01") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "2100-01-01") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<TopicoAuxiliar> lista = topicoaux.historialTopicoPorFechas(fechaInicio, fechaFin);
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
	public ResponseEntity<Map<String, Object>> historialTopicoFechasAnualAux(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "1900-01-01") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "2100-01-01") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<TopicoAuxiliar> lista = topicoaux.historialTopicoPorFechasAnual(fechaInicio, fechaFin);
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
	public ResponseEntity<Map<String, Object>> historialTopicoFechasMensualAux(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "1900-01-01") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "2100-01-01") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<TopicoAuxiliar> lista = topicoaux.historialTopicoPorFechasMensual(fechaInicio, fechaFin);
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
	public ResponseEntity<Map<String, Object>> historialTopicoFechasSemanalAux(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "1900-01-01") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "2100-01-01") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<TopicoAuxiliar> lista = topicoaux.historialTopicoPorFechasSemanal(fechaInicio, fechaFin);
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
