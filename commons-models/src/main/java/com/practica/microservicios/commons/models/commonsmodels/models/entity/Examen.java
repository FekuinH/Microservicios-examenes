package com.practica.microservicios.commons.models.commonsmodels.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "examenes")
public class Examen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@OneToMany(mappedBy = "examen", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = { "examen" }, allowSetters = true)
	private List<Pregunta> preguntas;

	public Examen() {
		this.preguntas = new ArrayList<Pregunta>();
	}

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas.clear();

		preguntas.forEach(pregunta -> {
			this.addPregunta(pregunta);
		});
	}

	public void addPregunta(Pregunta p) {
		this.preguntas.add(p);
		p.setExamen(this);
	}

	public void removePregunta(Pregunta p) {
		this.preguntas.remove(p);
		p.setExamen(null);
	}

	@Override
	public boolean equals(Object obj) {
		Examen e = (Examen) obj;

		return (this == obj) || (!(obj instanceof Alumno)) || (this.id != null && this.id.equals(e.getId()));
	}

}
