package com.example.caramelo.dto.request;

// Clase que representa la solicitud de registro (SignUp)
public class SignUpRequest {

	private String firstName; // Nombre del usuario
	private String lastName; // Apellido del usuario
	private String email; // Correo electrónico del usuario
	private String password; // Contraseña del usuario

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

	// Métodos de acceso para la contraseña
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
