package com.cibertec.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
		
				lista = topicoser.historialServicioPorId(idEstudiante);	
			
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
	

	
}
