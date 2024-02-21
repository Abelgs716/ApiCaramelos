package com.example.caramelo.dto.response.error;

import java.util.Date;

// Clase que representa la respuesta detallada para errores (ErrorDetailsResponse)
public class ErrorDetailsResponse {

	private Date timestamp; // Marca de tiempo del error
	private String message; // Mensaje descriptivo del error
	private String details; // Detalles adicionales del error

	// Constructor que inicializa los campos de la respuesta detallada de error
	public ErrorDetailsResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	// Métodos de acceso para la marca de tiempo
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	// Métodos de acceso para el mensaje
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// Métodos de acceso para los detalles
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
