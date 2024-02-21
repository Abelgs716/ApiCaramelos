package com.example.caramelo.dto.request;

// Clase que representa la solicitud de inicio de sesión (Signin)
public class SigninRequest {

	private String email; // Correo electrónico del usuario
	private String password; // Contraseña del usuario

	// Métodos de acceso para el correo electrónico
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Métodos de acceso para la contraseña
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
