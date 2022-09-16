package com.cibertec.controller;

/**
 * @author JORGE JACINTO
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Alumno;
import com.cibertec.entity.Categoria;
import com.cibertec.entity.Grado;
import com.cibertec.entity.Modalidad;
import com.cibertec.entity.Pais;
import com.cibertec.entity.Sede;
import com.cibertec.service.AlumnoService;
import com.cibertec.service.CategoriaService;
import com.cibertec.service.GradoService;
import com.cibertec.service.ModalidadService;
import com.cibertec.service.PaisService;
import com.cibertec.service.SedeService;
import com.cibertec.util.AppSettings;



@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {

	@Autowired
	private PaisService paisService;

	@Autowired
	private GradoService gradoService;

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private ModalidadService modalidadService;
	
	@Autowired
	private SedeService sedeService;
	
	@GetMapping("/listaPais")
	@ResponseBody
	public List<Pais> listaPais() {
		return paisService.listaTodos();
	}

	@GetMapping("/listaCategoria")
	@ResponseBody
	public List<Categoria> listaCategoria() {
		return categoriaService.listaTodos();
	}
	
	@GetMapping("/listaGrado")
	@ResponseBody
	public List<Grado> listaGrado() {
		return gradoService.listaTodos();
	}

	@GetMapping("/listaModalidad")
	@ResponseBody
	public List<Modalidad> listaModalidad() {
		return modalidadService.listaTodos();
				
	}
	
	@GetMapping("/listaSede")
	@ResponseBody
	public List<Sede> listaSede() {
		return sedeService.listaTodos();
				
	}
	
	@GetMapping("/listaAlumno")
	@ResponseBody
	public List<Alumno> listaAlumno() {
		return alumnoService.listaTodos();
				
	}
}
