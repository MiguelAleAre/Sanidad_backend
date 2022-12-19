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

import com.cibertec.entity.Vacuna;
import com.cibertec.entity.VacunacionEstudiante;
import com.cibertec.repository.TopicoEstudianteRepository;
import com.cibertec.service.VacunacionEstudianteService;
import com.cibertec.util.AppSettings;



@RestController
@RequestMapping("/url/vacunacionestudiante")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class VacunacionEstudianteController {
	
	@Autowired
	private VacunacionEstudianteService vacunservice;

	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<VacunacionEstudiante>> listaVacuEstudiante(){
		List<VacunacionEstudiante> lista = vacunservice.listaTodosVacunacionEstudiante();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraVacunacionEstudiantes")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaVacunacionEstudiante(@RequestBody VacunacionEstudiante obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
	
			Calendar dias = Calendar.getInstance();
			dias.setTime(new Date());
			dias.add(Calendar.HOUR, 7);
			
			Calendar dias2 = Calendar.getInstance();
			dias2.setTime(new Date());
			dias2.add(Calendar.DATE, 60);
			
			Calendar dias3 = Calendar.getInstance();
			dias3.setTime(new Date());
			dias3.add(Calendar.DATE, 90);
			
			
			
			Calendar dias4 = Calendar.getInstance();
			dias4.setTime(new Date());
			dias4.add(Calendar.DATE, 90);
			
			Calendar dias5 = Calendar.getInstance();
			dias5.setTime(new Date());
			dias5.add(Calendar.DATE, 120);
			
			
			obj.setDosis1(dias.getTime());
			obj.setDosis2(dias2.getTime());
			obj.setDosis3(dias3.getTime());
			
			obj.setEstado1(1);
			obj.setEstado2(0);
			obj.setEstado3(0);
			
			
			VacunacionEstudiante objSalida =  vacunservice.insertarVacunacionEstudiante(obj);
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
	
	@PostMapping("/registraVacunacionEstudiantes2")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaVacunacionEstudiante2(@RequestBody VacunacionEstudiante obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			
	
			Calendar dias = Calendar.getInstance();
			dias.setTime(new Date());
			dias.add(Calendar.HOUR, 7);
			
			Calendar dias2 = Calendar.getInstance();
			dias2.setTime(new Date());
			dias2.add(Calendar.DATE, 60);
			
			Calendar dias3 = Calendar.getInstance();
			dias3.setTime(new Date());
			dias3.add(Calendar.DATE, 90);
			
			
			
			Calendar dias4 = Calendar.getInstance();
			dias4.setTime(new Date());
			dias4.add(Calendar.DATE, 90);
			
			Calendar dias5 = Calendar.getInstance();
			dias5.setTime(new Date());
			dias5.add(Calendar.DATE, 120);
			
			
			obj.setDosis1(dias.getTime());
			obj.setDosis2(dias4.getTime());
			obj.setDosis3(dias5.getTime());
			
			obj.setEstado1(1);
			obj.setEstado2(0);
			obj.setEstado3(0);
			
			
			
			VacunacionEstudiante objSalida =  vacunservice.insertarVacunacionEstudiante(obj);
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
