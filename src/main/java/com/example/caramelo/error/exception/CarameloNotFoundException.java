package com.example.caramelo.error.exception;

// Clase de excepción personalizada para cuando no se encuentra un caramelo (CarameloNotFoundException)
public class CarameloNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// Constructor que recibe un mensaje descriptivo de la excepción
	public CarameloNotFoundException(String message) {
		super(message);
	}
}
