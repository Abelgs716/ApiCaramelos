package com.example.caramelo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

// Clase que representa la entidad Caramelo en la base de datos
@Entity
@Table(name = "caramelos")
public class Caramelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El nombre no puede estar vacío")
	private String nombre;

	@NotBlank(message = "Los ingredientes no puede estar vacío")
	private String ingredientes;

	@NotBlank(message = "El peso no puede estar vacío")
	@Pattern(regexp = "[0-9]+", message = "El peso solo debe contener números")
	private String peso;

	private String color;

	// Métodos de acceso para el ID
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// Métodos de acceso para el peso
	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	// Métodos de acceso para el color
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// Métodos de acceso para el nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Métodos de acceso para los ingredientes
	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
}
