package com.practica.microservicios.commons.commons.microservicios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;



import com.practica.microservicios.commons.commons.microservicios.services.IGenericService;

public class GenericController<E, S extends IGenericService<E>> {

	@Autowired
	protected S service;

	@GetMapping
	public ResponseEntity<?> findAll() {

		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {

		Optional<E> o = service.findById(id);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(o.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody E entity) {

		E entityDB = service.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(entityDB);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		service.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}
