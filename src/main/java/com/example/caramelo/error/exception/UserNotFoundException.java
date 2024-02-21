package com.example.caramelo.error.exception;

// Clase de excepción personalizada para cuando no se encuentra un usuario (UserNotFoundException)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// Constructor que recibe un mensaje descriptivo de la excepción
	public UserNotFoundException(String message) {
		super(message);
	}
}
