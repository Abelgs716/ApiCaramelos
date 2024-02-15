package com.example.caramelo.error.exception;

public class CarameloNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CarameloNotFoundException(String message) {
		super(message);
	}
}