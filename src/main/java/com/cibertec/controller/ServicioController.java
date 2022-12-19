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

import com.cibertec.entity.Servicio;
import com.cibertec.service.ServicioService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/servicio")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ServicioController {
	
	@Autowired
	private ServicioService serService;

	@GetMapping("/listaServicioPorDniLike/{dni}")
	@ResponseBody
	public ResponseEntity<List<Servicio>> listaServicioPorDniLike(@PathVariable("dni") String dni) {
		List<Servicio> lista  = null;
		try {
			if (dni.equals("todos")) {
				lista = serService.listaServicioPorDniLike("%");
			}else {
				lista = serService.listaServicioPorDniLike("%" + dni + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraServicio")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaServicio(@RequestBody Servicio obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
		
			Servicio objSalida =  serService.insertaActualizaServicio(obj);
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

	@PutMapping("/actualizaServicio")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaServicio(@RequestBody Servicio obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Servicio objSalida = serService.insertaActualizaServicio(obj);
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
	
	
	@DeleteMapping("/eliminaServicio/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaServicio(@PathVariable("id") int idServicio) {
		Map<String, Object> salida = new HashMap<>();
		try {
			serService.eliminaServicios(idServicio);
			salida.put("mensaje", "Se elimino correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se elimino de la manera correcta");
		}
		return ResponseEntity.ok(salida);
	}
}
