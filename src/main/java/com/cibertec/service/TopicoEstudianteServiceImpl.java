package com.cibertec.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.TopicoEstudiante;
import com.cibertec.repository.TopicoEstudianteRepository;

@Service
public class TopicoEstudianteServiceImpl implements TopicoEstudianteService{
	

	@Autowired
	private TopicoEstudianteRepository repository;

	@Override
	public List<TopicoEstudiante> listaTodosTopicoEstudiante() {
	   return repository.findAll();
	}

	@Override
	public TopicoEstudiante insertarTopicoEstudiante(TopicoEstudiante obj) {
		return repository.save(obj);
	}

	@Override
	public List<TopicoEstudiante> listaEstudiantePorIncidenteLike(String incidente) {
		return repository.listaTopicoEstuPorIncidenteLike(incidente);
	}

	@Override
	public List<TopicoEstudiante>buscaHistorialAlumno(int idEstudiante) {
		return repository.historialEstudiandoPorId(idEstudiante);
		
	}

	

	@Override
	public List<TopicoEstudiante> historialTopicoPorFechas(String fechaini, String fechafin) {

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return repository.historialTopicoPorFechas(date2, date1);
	}

	@Override
	public List<TopicoEstudiante> historialTopicoPorFechasMensual(String fechaini, String fechafin) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
//		Date fechaNacimiento2 = sdf2.parse(fechFin);
		
		fecha = LocalDate.now();
		
		fecha2 = LocalDate.now().minusMonths(1);
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return repository.historialTopicoPorFechas(date2, date1);
	}

	@Override
	public List<TopicoEstudiante> historialTopicoPorFechasAnual(String fechaini, String fechafin) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
//		Date fechaNacimiento2 = sdf2.parse(fechFin);
		
		fecha = LocalDate.now();
		
		fecha2 = LocalDate.now().minusYears(1);
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return repository.historialTopicoPorFechas(date2, date1);
	}

	@Override
	public List<TopicoEstudiante> historialTopicoPorFechasSemanal(String fechaini, String fechafin) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
        fecha = LocalDate.now();
		
		fecha2 = LocalDate.now().minusWeeks(1);
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return repository.historialTopicoPorFechas(date2, date1);
	}
	
	


}
