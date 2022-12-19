package com.cibertec.controller;

/**
 * @author JORGE JACINTO
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Alumno;
import com.cibertec.entity.Categoria;
import com.cibertec.entity.Grado;
import com.cibertec.entity.Modalidad;
import com.cibertec.entity.Nivel;
import com.cibertec.entity.Pais;
import com.cibertec.entity.Sede;
import com.cibertec.entity.Sexo;
import com.cibertec.entity.Vacuna;
import com.cibertec.entity.Condicion;
import com.cibertec.service.SexoService;

import com.cibertec.service.CondicionService;
import com.cibertec.service.NivelService;
import com.cibertec.util.AppSettings;
import com.cibertec.entity.Nivelgrado;
import com.cibertec.service.UbigeoService;
import com.cibertec.service.VacunaService;




@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {

	@Autowired
	private SexoService sexoService;
	
	@Autowired
	private CondicionService condService;
	
	@Autowired
	private NivelService nivService;
	
	@Autowired
	private VacunaService vanService;
	
	@GetMapping("/listaVacunas")
	@ResponseBody
	public List<Vacuna> listaVacuna() {
		return vanService.listaVacunas();
	}
	


	@GetMapping("/listaNiveles")
	@ResponseBody
	public List<Nivel> listaNivel() {
		return nivService.listaTodos();
	}
	

	@GetMapping("/listaSexo")
	@ResponseBody
	public List<Sexo> listaSexo() {
		return sexoService.listaTodos();
	}
	
	@GetMapping("/listaCondicion")
	@ResponseBody
	public List<Condicion> listaCondicion() {
		return condService.listaTodos();
	}
	

	

	
	
    @Autowired
	private UbigeoService ubigeoService;


	@GetMapping("/listaDepartamentos")
	@ResponseBody
	public List<String> listaDepartamentos() {
		return ubigeoService.listaDepartamentos();
	}

	@GetMapping("/listaProvincias/{paramDep}")
	@ResponseBody
	public List<String> listaProvincias(@PathVariable("paramDep") String dep) {
		return ubigeoService.listaProvincias(dep);
	}

	@GetMapping("/listaDistritos/{paramDep}/{paramProv}")
	@ResponseBody
	public List<Nivelgrado> listaDistritos(@PathVariable("paramDep") String dep, @PathVariable("paramProv") String prov) {
		return ubigeoService.listaDistritos(dep, prov);
	}
	
}
