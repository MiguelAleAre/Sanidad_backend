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

import com.cibertec.entity.Auxiliar;
import com.cibertec.service.AuxiliarService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/auxiliar")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AuxiliarController {
	
	@Autowired
	private AuxiliarService auxService;

	

	@GetMapping("/listaAuxiliarPorDniLike/{dni}")
	@ResponseBody
	public ResponseEntity<List<Auxiliar>> listaAuxiliarPorDniLike(@PathVariable("dni") String dni) {
		List<Auxiliar> lista  = null;
		try {
			if (dni.equals("todos")) {
				lista = auxService.listaAuxiliarPorDniLike("%");
			}else {
				lista = auxService.listaAuxiliarPorDniLike("%" + dni + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraAuxiliar")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaAuxiliar(@RequestBody Auxiliar obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
		
			Auxiliar objSalida =  auxService.insertaActualizaAuxiliar(obj);
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

	@PutMapping("/actualizaAuxiliar")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaAuxiliar(@RequestBody Auxiliar obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Auxiliar objSalida = auxService.insertaActualizaAuxiliar(obj);
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
	
	
	@DeleteMapping("/eliminaAuxiliar/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaAuxiliar(@PathVariable("id") int idAuxiliar) {
		Map<String, Object> salida = new HashMap<>();
		try {
			auxService.eliminaAuxiliares(idAuxiliar);
			salida.put("mensaje", "Se elimino correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se elimino de la manera correcta");
		}
		return ResponseEntity.ok(salida);
	}
}
