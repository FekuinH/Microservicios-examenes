package com.practica.microservicios.app.cursos.microserviciocursos.models.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practica.microservicios.app.cursos.microserviciocursos.models.repository.CursoRepository;
import com.practica.microservicios.commons.commons.microservicios.services.GenericServiceImpl;
import com.practica.microservicios.commons.models.commonsmodels.models.entity.Curso;

@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso, CursoRepository> implements ICursoService {

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		
		
		return repository.findCursoByAlumnoId(id);
	}

}
