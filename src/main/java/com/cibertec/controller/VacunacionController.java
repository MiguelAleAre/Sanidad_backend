package com.cibertec.controller;


import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import com.cibertec.entity.Estudiante;
import com.cibertec.entity.Vacunacion;
import com.cibertec.entity.Seleccion;
import com.cibertec.entity.TopicoEstudiante;
import com.cibertec.entity.Usuario;
import com.cibertec.entity.Vacuna;
import com.cibertec.service.EstudianteService;
import com.cibertec.service.VacunaService;
import com.cibertec.service.VacunacionService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/vacunacion")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)

public class VacunacionController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private VacunaService vacunaService;
	
	@Autowired
	private VacunacionService vacunacionService;
	
	@GetMapping("/cargarEstudiante/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Estudiante>> listaEstudiante(@PathVariable("filtro")String filtro){
		
		List<Estudiante> lista = null;
		if(filtro.equals("todos")) {
			lista = estudianteService.listaEstudiantePorNombreLike("%");
		}else {
			lista = estudianteService.listaEstudiantePorNombreLike("%"+filtro+"%");
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/cargarVacuna/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Vacuna>> listaVacuna(@PathVariable("filtro") String filtro){
		List<Vacuna> lista = null;
		if(filtro.equals("todos")) {
			lista = vacunaService.listaVacunasPorVacuna("%");
		}else {
			lista = vacunaService.listaVacunasPorVacuna("%"+filtro+"%");
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraVacuna1")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaVacuna1(@RequestBody Vacunacion obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			
			
			obj.setVacunaz("Tetanos");
			
			Calendar dias = Calendar.getInstance();
			dias.setTime(new Date());
			dias.add(Calendar.HOUR, 7);
			
			Calendar dias2 = Calendar.getInstance();
			dias2.setTime(new Date());
			dias2.add(Calendar.MONTH, 3);
			
			Calendar dias3 = Calendar.getInstance();
			dias3.setTime(new Date());
			dias3.add(Calendar.MONTH, 6);
			
			obj.setFechaDosis1(dias.getTime());
			obj.setFechaDosis2(dias2.getTime());
			obj.setFechaDosis3(dias3.getTime());
			
			obj.setEstado1(1);
			obj.setEstado2(0);
			obj.setEstado3(0);
			
			
			
			Vacunacion objSalida =  vacunacionService.insertaEjemplo1(obj);
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

	@PostMapping("/registraVacuna2")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaVacuna2(@RequestBody Vacunacion obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			
			
			obj.setVacunaz("Influenza");
			
			Calendar dias = Calendar.getInstance();
			dias.setTime(new Date());
			dias.add(Calendar.HOUR, 7);
			
			Calendar dias2 = Calendar.getInstance();
			dias2.setTime(new Date());
			dias2.add(Calendar.MONTH, 6);
			
			Calendar dias3 = Calendar.getInstance();
			dias3.setTime(new Date());
			dias3.add(Calendar.MONTH, 12);
			
			obj.setFechaDosis1(dias.getTime());
			obj.setFechaDosis2(dias2.getTime());
			obj.setFechaDosis3(dias3.getTime());
			
			obj.setEstado1(1);
			obj.setEstado2(0);
			obj.setEstado3(0);
			
			
			
			Vacunacion objSalida =  vacunacionService.insertaEjemplo1(obj);
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
	
	@GetMapping("/historialVacunaPorNombre1")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> historialVacunaPorNombre1(
			@RequestParam(name = "nombre", required = false, defaultValue = "") String nombre
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Vacunacion> lista = vacunacionService.historialVacunasPorNombre1(nombre);
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
	
	@GetMapping("/historialVacunaPorNombre2")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> historialVacunaPorNombre2(
			@RequestParam(name = "nombre", required = false, defaultValue = "") String nombre
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Vacunacion> lista = vacunacionService.historialVacunasPorNombre2(nombre);
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
	
	@GetMapping("/historialVacunaFechas")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> historialVacunaFechas(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "1900-01-01") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "2100-01-01") String fechaFin,
			@RequestParam(name = "Vacunaz", required = false, defaultValue = "") String Vacunaz
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Vacunacion> lista = vacunacionService.historialVacunasPorFechas(fechaInicio, fechaFin, Vacunaz);
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
	
	@GetMapping("/historialVacunaFechasAnual")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> historialVacunaFechasAnual(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "1900-01-01") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "2100-01-01") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Vacunacion> lista = vacunacionService.historialVacunasPorFechasAnual(fechaInicio, fechaFin);
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
	
	@GetMapping("/historialVacunaFechasMensual")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> historialVacunaFechasMensual(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "1900-01-01") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "2100-01-01") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Vacunacion> lista = vacunacionService.historialVacunasPorFechasMensual(fechaInicio, fechaFin);
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
	
	@GetMapping("/historialVacunaFechasSemanal")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> historialVacunaFechasSemanal(
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "1900-01-01") String fechaInicio,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "2100-01-01") String fechaFin
			) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Vacunacion> lista = vacunacionService.historialVacunasPorFechasSemanal(fechaInicio, fechaFin);
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

	
	@PutMapping("/actualizaVacunacion1")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaVacunacion(@RequestBody Vacunacion obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Vacunacion objSalida = vacunacionService.insertaEjemplo1(obj);
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
	
	@PutMapping("/actualizaVacunacion2")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaVacunacion2(@RequestBody Vacunacion obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Vacunacion objSalida = vacunacionService.insertaEjemplo2(obj);
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
	
	@PutMapping("/actualizaVacunacion3")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaVacunacion3(@RequestBody Vacunacion obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Vacunacion objSalida = vacunacionService.insertaEjemplo3(obj);
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
	
	
}
