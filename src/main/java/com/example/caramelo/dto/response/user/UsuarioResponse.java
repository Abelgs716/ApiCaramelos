package com.example.caramelo.dto.response.user;

// Clase que representa la respuesta de usuario (UsuarioResponse)
public class UsuarioResponse {

	private String firstName; // Nombre del usuario
	private String lastName; // Apellido del usuario
	private String email; // Correo electrónico del usuario
	private String rol; // Rol del usuario

	// Constructor que inicializa los campos de la respuesta de usuario
	public UsuarioResponse(String firstName, String lastName, String email, String rol) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.rol = rol;
	}

	// Métodos de acceso para el nombre
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Métodos de acceso para el apellido
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Métodos de acceso para el correo electrónico
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Métodos de acceso para el rol
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
