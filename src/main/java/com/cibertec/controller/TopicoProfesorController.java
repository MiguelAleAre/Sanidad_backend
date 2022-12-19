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

import com.cibertec.entity.TopicoProfesor;
import com.cibertec.service.TopicoProfesorService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/topicoprofesor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class TopicoProfesorController {
	
	@Autowired
	private TopicoProfesorService topicopro;


	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<TopicoProfesor>> listaProfesorTopico(){
		List<TopicoProfesor> lista = topicopro.listaTodosTopicoProfesor();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaTopicoProfesorPorIncidenteLike/{inci}")
	@ResponseBody
	public ResponseEntity<List<TopicoProfesor>> listaTopicoProfePorIncidenteLike(@PathVariable("inci") String inci) {
		List<TopicoProfesor> lista  = null;
		try {
			if (inci.equals("todos")) {
				lista = topicopro.listaProfesorPorIncidenteLike("%");
			}else {
				lista = topicopro.listaProfesorPorIncidenteLike("%" + inci + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/historialProfesorPorId/{idEstudiante}")
	@ResponseBody
	public ResponseEntity<List<TopicoProfesor>> historialProfesorPorId(@PathVariable("idProfesor") int idProfesor) {
		List<TopicoProfesor> lista  = null;
		try {
		
				lista = topicopro.historialProfesorPorId(idProfesor);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraTopicoProfesores")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaProfesor(@RequestBody TopicoProfesor obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			//obj.setIdTopicoestu(0);
			
			Calendar dias = Calendar.getInstance();
			dias.setTime(new Date());
			dias.add(Calendar.HOUR, 7);
			
			obj.setFechaRegistro(dias.getTime());
			
			TopicoProfesor objSalida =  topicopro.insertarTopicoProfesor(obj);
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
