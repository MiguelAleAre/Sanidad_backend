package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.entity.Vacuna_has_Vacunacion;
import com.cibertec.entity.Vacunacion;
import com.cibertec.repository.VacunaHasVacunacionRepository;
import com.cibertec.repository.VacunacionRepository;

@Service
public class VacunacionServiceImpl implements VacunacionService{

	@Autowired
	private VacunacionRepository vacunacionRepository;
	
	@Autowired
	private VacunaHasVacunacionRepository detalleRespository;
	
	@Override
	@Transactional
	public Vacunacion insertaVacunacion(Vacunacion bean) {
		Vacunacion vacunacion = vacunacionRepository.save(bean);
		for(Vacuna_has_Vacunacion l: vacunacion.getDetallesVacunacion()) {
			l.getVacunahasvacunacionPK().setIdVacunacion(vacunacion.getIdVacunacion());
			detalleRespository.save(l);
		}
		
		return vacunacion;
	}

	@Override
	public List<Vacunacion> listaVacunacion(int idEstudiante) {
		return vacunacionRepository.listaVacunacion(idEstudiante);
	}

	@Override
	public Optional<Vacunacion> listaVacunacionPorId(int idVacunacion) {
		return vacunacionRepository.findById(idVacunacion);
	}

	@Override
	public List<Vacuna_has_Vacunacion> listaDetalle(int idVacunacion) {
		return detalleRespository.listaDetalle(idVacunacion);
	}

}
