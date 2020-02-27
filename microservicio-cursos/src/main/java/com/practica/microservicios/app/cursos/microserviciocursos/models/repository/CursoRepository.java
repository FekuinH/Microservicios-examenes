package com.practica.microservicios.app.cursos.microserviciocursos.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.practica.microservicios.commons.models.commonsmodels.models.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {

	@Query("select c from Curso c join fetch c.alumnos a where a.id=?1")
	public Curso findCursoByAlumnoId(Long id);
}
