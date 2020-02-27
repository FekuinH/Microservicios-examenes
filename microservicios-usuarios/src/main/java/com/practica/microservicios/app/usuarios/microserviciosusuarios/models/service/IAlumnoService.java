package com.practica.microservicios.app.usuarios.microserviciosusuarios.models.service;

import java.util.List;

import com.practica.microservicios.commons.commons.microservicios.services.IGenericService;
import com.practica.microservicios.commons.models.commonsmodels.models.entity.Alumno;

public interface IAlumnoService extends IGenericService<Alumno> {
	
	public List<Alumno> findByNombreOrApellido(String term);

}
