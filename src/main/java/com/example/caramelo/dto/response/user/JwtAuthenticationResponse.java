package com.example.caramelo.dto.response.user;

// Clase que representa la respuesta de autenticación JWT (JwtAuthenticationResponse)
public class JwtAuthenticationResponse {

	private String token; // Token de autenticación JWT

	// Constructor que inicializa el campo del token
	public JwtAuthenticationResponse(String token) {
		this.token = token;
	}

	// Método de acceso para el token
	public String getToken() {
		return token;
	}

	// Método de modificación para el token
	public void setToken(String token) {
		this.token = token;
	}

	// Método estático para obtener un constructor de la respuesta de autenticación
	// JWT
	public static JwtAuthenticationResponseBuilder builder() {
		return new JwtAuthenticationResponseBuilder();
	}

	// Clase interna para construir la respuesta de autenticación JWT de manera más
	// fluida
	public static class JwtAuthenticationResponseBuilder {
		private String token;

		// Método para configurar el token
		public JwtAuthenticationResponseBuilder token(String token) {
			this.token = token;
			return this;
		}

		// Método para construir la respuesta de autenticación JWT
		public JwtAuthenticationResponse build() {
			return new JwtAuthenticationResponse(token);
		}
	}
}
