package com.practica.microservicios.app.examenes.microservicioexamenes.models.services;


import java.util.List;

import com.practica.microservicios.commons.commons.microservicios.services.IGenericService;
import com.practica.microservicios.commons.models.commonsmodels.models.entity.Examen;

public interface IExamenService extends IGenericService<Examen>{
 
	public List<Examen> buscarPorNombre(String nombre);	
}
