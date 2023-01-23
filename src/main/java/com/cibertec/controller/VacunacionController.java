package com.cibertec.controller;


import java.util.ArrayList;
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


import com.cibertec.entity.DataRegistroVacunacion;
import com.cibertec.entity.Estudiante;

import com.cibertec.entity.Vacuna_has_Vacunacion;
import com.cibertec.entity.Vacuna_has_VacunacionPK;
import com.cibertec.entity.Vacunacion;
import com.cibertec.entity.Seleccion;
import com.cibertec.entity.Usuario;
import com.cibertec.entity.Vacuna;
import com.cibertec.service.EstudianteService;
import com.cibertec.service.VacunaService;
import com.cibertec.service.VacunacionService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/prestamo")
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
	
	@PostMapping("/registroVacunacion")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> registra(@RequestBody DataRegistroVacunacion bean){
		Map<String, Object> salida = new HashMap<>();
		
		List<Vacuna_has_Vacunacion> detalles = new ArrayList<Vacuna_has_Vacunacion>();
		for(Seleccion seleccion: bean.getSeleccionados()) {
			
			Vacuna_has_VacunacionPK pk = new Vacuna_has_VacunacionPK();
			pk.setIdVacuna(seleccion.getIdVacuna());
			
			Vacuna_has_Vacunacion lsp = new Vacuna_has_Vacunacion();
			lsp.setVacunahasvacunacionPK(pk);
			
			detalles.add(lsp);
		}
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1);
		
		try {
			Vacunacion vacunacion = new Vacunacion();
			vacunacion.setEstudiante(bean.getEstudiante());
			vacunacion.setDetallesVacunacion(detalles);
			vacunacion.setUsuario(usuario);
			vacunacion.setFechaDosis1(Calendar.getInstance().getTime());
			Calendar dias = Calendar.getInstance();
			dias.setTime(new Date());
			dias.add(Calendar.DATE, 30);
			vacunacion.setFechaDosis2(dias.getTime());
			Calendar dias2 = Calendar.getInstance();
			dias2.setTime(new Date());
			dias2.add(Calendar.DATE, 60);
			vacunacion.setFechaDosis3(dias2.getTime());
			
			Vacunacion obj = vacunacionService.insertaVacunacion(vacunacion);
			
			String mensaje="";
			if(obj !=null) {
				mensaje = "Se generó el prestamo con codigo N°: "+ obj.getIdVacunacion()+ "<br><br>";
				mensaje += "Alumno: " + obj.getEstudiante().getNombrediante()+ "<br><br>";
				mensaje += "<table class=\"table\"><tr><td>Libro</td><td>Año</td><td>Serie</td></tr>";
				for(Seleccion s: bean.getSeleccionados()) {
					mensaje += "<tr><td>" + s.getVacuna();


				}
				mensaje += "</table><br>";
				mensaje += "Fecha de Devolucion: " + obj.getFechaDosis2();
				mensaje += "</table><br>";
				mensaje += "Fecha de Devolucion: " + obj.getFechaDosis3();
				
				bean.getSeleccionados().clear();
				salida.put("mensaje", mensaje);
			}else {
				salida.put("mensaje", "No se registro, consulte con el administrador" );
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registro, consulte con el administrador");
		}
		return ResponseEntity.ok(salida);
		
	}
	
}
