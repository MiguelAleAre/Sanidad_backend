package com.cibertec.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.TopicoAuxiliar;
import com.cibertec.repository.TopicoAuxiliarRepository;

@Service
public class TopicoAuxiliarServiceImpl implements TopicoAuxiliarService{
	
	@Autowired
	private TopicoAuxiliarRepository repository;

	@Override
	public List<TopicoAuxiliar> listaTodosTopicoAuxiliar() {
		return repository.findAll();
	}

	@Override
	public TopicoAuxiliar insertarTopicoAuxiliar(TopicoAuxiliar obj) {
		return repository.save(obj);
	}

	@Override
	public List<TopicoAuxiliar> listaAuxiliarPorIncidenteLike(String incidente) {
		return repository.listaTopicoAuxiPorIncidenteLike(incidente);
	}

	@Override
	public List<TopicoAuxiliar> buscaHistorialAuxiliar(int idAuxiliar) {
		return repository.historialAuxiliarPorId(idAuxiliar);
	}

	@Override
	public List<TopicoAuxiliar> historialTopicoPorFechasMensual(String fechaini, String fechafin) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
//		Date fechaNacimiento2 = sdf2.parse(fechFin);
		
		fecha = LocalDate.now().plusDays(1);
		
		fecha2 = LocalDate.now().minusMonths(1);
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return repository.historialTopicoPorFechas(date2, date1);
	}

	@Override
	public List<TopicoAuxiliar> historialTopicoPorFechasAnual(String fechaini, String fechafin) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
//		Date fechaNacimiento2 = sdf2.parse(fechFin);
		
		fecha = LocalDate.now().plusDays(1);
		
		fecha2 = LocalDate.now().minusYears(1);
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return repository.historialTopicoPorFechas(date2, date1);
	}

	@Override
	public List<TopicoAuxiliar> historialTopicoPorFechasSemanal(String fechaini, String fechafin) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
        fecha = LocalDate.now().plusDays(1);
		
		fecha2 = LocalDate.now().minusWeeks(1);
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return repository.historialTopicoPorFechas(date2, date1);
	}

	@Override
	public List<TopicoAuxiliar> historialTopicoPorFechas(String fechaini, String fechafin) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return repository.historialTopicoPorFechas(date1, date2);
	}


}
