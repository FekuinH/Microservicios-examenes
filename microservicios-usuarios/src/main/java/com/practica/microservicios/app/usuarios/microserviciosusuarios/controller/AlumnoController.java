package com.practica.microservicios.app.usuarios.microserviciosusuarios.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practica.microservicios.app.usuarios.microserviciosusuarios.models.service.IAlumnoService;
import com.practica.microservicios.commons.commons.microservicios.controllers.GenericController;
import com.practica.microservicios.commons.models.commonsmodels.models.entity.Alumno;

@RestController
public class AlumnoController extends GenericController<Alumno, IAlumnoService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id) {

		Optional<Alumno> o = service.findById(id);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Alumno alumnoDB = o.get();
		alumnoDB.setNombre(alumno.getNombre());
		alumnoDB.setApellido(alumno.getApellido());
		alumnoDB.setEmail(alumno.getEmail());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDB));

	}

	@GetMapping("/buscar/{term}")
	public ResponseEntity<?> filrar(@PathVariable String term) {

		return ResponseEntity.ok(service.findByNombreOrApellido(term));
	}

}
