package com.cibertec.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.TopicoServicio;
import com.cibertec.repository.TopicoServicioRepository;

@Service
public class TopicoServicioServiceImpl implements TopicoServicioService{
	
	@Autowired
	TopicoServicioRepository repository;

	@Override
	public List<TopicoServicio> listaTodosTopicoServicio() {
		return repository.findAll();
	}

	@Override
	public TopicoServicio insertarTopicoServicio(TopicoServicio obj) {
		return repository.save(obj);
		}

	@Override
	public List<TopicoServicio> listaServicioPorIncidenteLike(String incidente) {
		return repository.listaTopicoServicioPorIncidenteLike(incidente);
	}

	@Override
	public List<TopicoServicio> buscaHistorialServicio(int idServicio) {
		return repository.historialServicioPorId(idServicio);
	}

	@Override
	public List<TopicoServicio> historialTopicoPorFechasMensual(String fechaini, String fechafin) {
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
	public List<TopicoServicio> historialTopicoPorFechasAnual(String fechaini, String fechafin) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
//		Date fechaNacimiento2 = sdf2.parse(fechFin);
		
		fecha = LocalDate.now();
		
		fecha2 = LocalDate.now().minusYears(1);
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return repository.historialTopicoPorFechas(date2, date1);
	}

	@Override
	public List<TopicoServicio> historialTopicoPorFechasSemanal(String fechaini, String fechafin) {
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
	public List<TopicoServicio> historialTopicoPorFechas(String fechaini, String fechafin) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return repository.historialTopicoPorFechas(date1, date2);
	}



}
