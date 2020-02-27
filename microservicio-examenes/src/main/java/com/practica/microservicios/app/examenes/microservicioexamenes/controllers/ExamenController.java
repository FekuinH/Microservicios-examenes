package com.practica.microservicios.app.examenes.microservicioexamenes.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practica.microservicios.app.examenes.microservicioexamenes.models.services.IExamenService;
import com.practica.microservicios.commons.commons.microservicios.controllers.GenericController;
import com.practica.microservicios.commons.models.commonsmodels.models.entity.Examen;

@RestController
public class ExamenController extends GenericController<Examen, IExamenService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {

		Optional<Examen> o = service.findById(id);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Examen examenDb = o.get();
		examenDb.setNombre(examen.getNombre());

		// recorro las preguntas del examenBD, filtro las preguntas que estan en el
		// nuevo json y no en el examenBD y las remuevo
		examenDb.getPreguntas().stream().filter(p -> !examen.getPreguntas().contains(p))
				.forEach(examenDb::removePregunta);

		examenDb.setPreguntas(examen.getPreguntas());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> buscar(@PathVariable String term){
		return ResponseEntity.ok(service.buscarPorNombre(term));
	}

	
}
