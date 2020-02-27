package com.practica.microservicios.app.cursos.microserviciocursos.models.service;

import com.practica.microservicios.commons.commons.microservicios.services.IGenericService;
import com.practica.microservicios.commons.models.commonsmodels.models.entity.Curso;

public interface ICursoService extends IGenericService<Curso>{

	public Curso findCursoByAlumnoId(Long id);
}
