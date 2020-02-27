package com.practica.microservicios.app.usuarios.microserviciosusuarios.models.service;


import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practica.microservicios.app.usuarios.microserviciosusuarios.models.repository.AlumnoRepository;
import com.practica.microservicios.commons.commons.microservicios.services.GenericServiceImpl;
import com.practica.microservicios.commons.models.commonsmodels.models.entity.Alumno;

@Service
public class AlumnoServiceImpl extends GenericServiceImpl<Alumno, AlumnoRepository> implements IAlumnoService {

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
		
		return repository.findByNombreOrApellido(term);
	}

	
	

}
