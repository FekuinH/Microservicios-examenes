package com.practica.microservicios.app.examenes.microservicioexamenes.models.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practica.microservicios.app.examenes.microservicioexamenes.models.repository.IExamenRepository;
import com.practica.microservicios.commons.commons.microservicios.services.GenericServiceImpl;
import com.practica.microservicios.commons.models.commonsmodels.models.entity.Examen;

@Service
public class ExamenServiceImpl extends GenericServiceImpl<Examen, IExamenRepository> implements IExamenService {

	@Override
	@Transactional(readOnly = true)
	public List<Examen> buscarPorNombre(String nombre) {
		
		return repository.buscarPorNombre(nombre);
	}

	

}
