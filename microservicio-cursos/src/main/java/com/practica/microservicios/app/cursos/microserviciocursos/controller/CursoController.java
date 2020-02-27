package com.practica.microservicios.app.cursos.microserviciocursos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practica.microservicios.app.cursos.microserviciocursos.models.service.ICursoService;
import com.practica.microservicios.commons.commons.microservicios.controllers.GenericController;
import com.practica.microservicios.commons.models.commonsmodels.models.entity.Alumno;
import com.practica.microservicios.commons.models.commonsmodels.models.entity.Curso;
import com.practica.microservicios.commons.models.commonsmodels.models.entity.Examen;

@RestController
public class CursoController extends GenericController<Curso, ICursoService> {

	@PutMapping("/{id{")
	public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id) {

		Optional<Curso> o = this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Curso cursoDb = o.get();
		cursoDb.setNombre(curso.getNombre());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
	}

	@PutMapping("/{id}/asignar")
	public ResponseEntity<?> asignarAlumnos(@PathVariable Long id, @RequestBody List<Alumno> alumnos) {

		Optional<Curso> o = this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();

		alumnos.forEach(alumno -> {
			cursoDb.addAlumno(alumno);
		});

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));

	}

	@PutMapping("/{id}/eliminar")
	public ResponseEntity<?> eliminarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {

		Optional<Curso> o = this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();

		cursoDb.removeAlumno(alumno);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));

	}

	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> buscarPorAlumnoId(@PathVariable Long id) {
		Curso curso = service.findCursoByAlumnoId(id);

		return ResponseEntity.ok(curso);
	}

	@PutMapping("/{id}/asignar-examen")
	public ResponseEntity<?> asignarExamenes(@PathVariable Long id, @RequestBody List<Examen> examenes) {

		Optional<Curso> o = this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();

		examenes.forEach(examen -> {
			cursoDb.addExamen(examen);
		});

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));

	}

	@PutMapping("/{id}/eliminar-examen")
	public ResponseEntity<?> eliminarExamen(@PathVariable Long id, @RequestBody Examen examen) {

		Optional<Curso> o = this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();

		cursoDb.removeExamen(examen);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));

	}

}
