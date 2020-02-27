package com.practica.microservicios.app.examenes.microservicioexamenes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.practica.microservicios.commons.models.commonsmodels.models.entity.Examen;

public interface IExamenRepository extends CrudRepository<Examen, Long> {

	@Query("select e from Examen e where e.nombre like %?1%")
	public List<Examen> buscarPorNombre(String nombre);
}
