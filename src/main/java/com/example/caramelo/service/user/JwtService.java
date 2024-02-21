package com.example.caramelo.service.user;

import org.springframework.security.core.userdetails.UserDetails;

// Interfaz para proporcionar servicios relacionados con el token JWT
public interface JwtService {
    String extractUserName(String token); // Extraer el nombre de usuario del token

    String generateToken(UserDetails userDetails); // Generar un nuevo token para un usuario

    boolean isTokenValid(String token, UserDetails userDetails); // Verificar si un token es válido para un usuario
}
