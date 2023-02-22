package com.cibertec.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cibertec.entity.Vacunacion;
import com.cibertec.repository.VacunacionRepository;

@Service
public class VacunacionServiceImpl implements VacunacionService{

	@Autowired
	private VacunacionRepository vacunacionRepository;
	

	@Override
	public List<Vacunacion> listaVacunacion(int idEstudiante) {
		return vacunacionRepository.listaVacunacion(idEstudiante);
	}

	@Override
	public Optional<Vacunacion> listaVacunacionPorId(int idVacunacion) {
		return vacunacionRepository.findById(idVacunacion);
	}

	@Override
	public Vacunacion insertaEjemplo1(Vacunacion bean) {
		return vacunacionRepository.save(bean);
	}

	@Override
	public Vacunacion insertaEjemplo2(Vacunacion bean) {
		return vacunacionRepository.save(bean);
	}

	@Override
	public Vacunacion insertaEjemplo3(Vacunacion bean) {
		return vacunacionRepository.save(bean);
	}

	@Override
	public List<Vacunacion> historialVacunasPorFechasMensual(String fechaini, String fechafin) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
//		Date fechaNacimiento2 = sdf2.parse(fechFin);
		
		fecha = LocalDate.now().plusDays(1);
		
		fecha2 = LocalDate.now().minusMonths(1);
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return vacunacionRepository.historialVacunaPorFechas(date2, date1);
	}

	@Override
	public List<Vacunacion> historialVacunasPorFechasAnual(String fechaini, String fechafin) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
//		Date fechaNacimiento2 = sdf2.parse(fechFin);
		
		fecha = LocalDate.now().plusDays(1);
		
		fecha2 = LocalDate.now().minusYears(1);
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return vacunacionRepository.historialVacunaPorFechas(date2, date1);
	}

	@Override
	public List<Vacunacion> historialVacunasPorFechasSemanal(String fechaini, String fechafin) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
        fecha = LocalDate.now().plusDays(1);
		
		fecha2 = LocalDate.now().minusWeeks(1);
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return vacunacionRepository.historialVacunaPorFechas(date2, date1);
	}

	@Override
	public List<Vacunacion> historialVacunasPorFechas(String fechaini, String fechafin,String Vacunaz) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha = LocalDate.parse(fechaini, formato); 
		
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha2 = LocalDate.parse(fechafin, formato); 
		
		
		
		Date date1 = java.sql.Date.valueOf(fecha);
		
		Date date2 = java.sql.Date.valueOf(fecha2);
		
		return vacunacionRepository.historialVacunaPorFechasEspe(date1, date2,Vacunaz);
	}

	@Override
	public List<Vacunacion> historialVacunasPorNombre1(String nombre) {

		String nom="Tetanos";
		
		
		return vacunacionRepository.historialVacunaPorNombre(nom);
		
	}

	@Override
	public List<Vacunacion> historialVacunasPorNombre2(String nombre) {
		
		String nom="Influenza"; 
		
		return vacunacionRepository.historialVacunaPorNombre(nom);
	}


}
