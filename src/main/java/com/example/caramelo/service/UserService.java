package com.example.caramelo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.caramelo.dto.response.user.UsuarioResponse;

// Interfaz para proporcionar servicios relacionados con los usuarios
public interface UserService {

	UserDetailsService userDetailsService(); // Obtener detalles del usuario para la autenticación

	List<UsuarioResponse> getAllUsers(); // Obtener la lista de todos los usuarios

}
