package com.example.caramelo.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

// Clase que representa la entidad Usuario y implementa UserDetails para la autenticación de Spring Security
@Entity
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName; // Nombre del usuario
	private String lastName; // Apellido del usuario

	@Column(unique = true)
	private String email; // Correo electrónico del usuario
	private String password; // Contraseña del usuario

	@ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "usuario_rol")
	@Column(name = "RolesUsuario")
	private Set<Role> roles = new HashSet<>(); // Conjunto de roles del usuario

	@Transactional
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		roles.size();

		// Mapear los roles a objetos GrantedAuthority
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
	}

	// Métodos de acceso para el nombre de usuario
	@Override
	public String getUsername() {
		return email;
	}

	// Métodos que indican que la cuenta no expira, no está bloqueada y las
	// credenciales no expiran
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// Método que indica que el usuario está habilitado
	@Override
	public boolean isEnabled() {
		return true;
	}

	// Método de acceso para la contraseña del usuario
	@Override
	public String getPassword() {
		return password;
	}

	// Métodos de modificación para los campos del usuario
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Métodos de acceso para el conjunto de roles del usuario
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	// Métodos de acceso para el ID del usuario
	public Long getId() {
		return id;
	}

	// Métodos de acceso para el nombre del usuario
	public String getFirstName() {
		return firstName;
	}

	// Métodos de acceso para el apellido del usuario
	public String getLastName() {
		return lastName;
	}

	// Métodos de acceso para el correo electrónico del usuario
	public String getEmail() {
		return email;
	}
}
