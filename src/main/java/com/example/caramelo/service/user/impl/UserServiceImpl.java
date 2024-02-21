package com.example.caramelo.service.user.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.caramelo.dto.response.user.UsuarioResponse;
import com.example.caramelo.repository.UserRepository;
import com.example.caramelo.service.UserService;

import lombok.RequiredArgsConstructor;

// Implementación de la interfaz UserService que proporciona servicios relacionados con los usuarios
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Método para obtener un UserDetailsService personalizado basado en el correo
    // electrónico del usuario
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                // Buscar al usuario por su correo electrónico
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    // Método para obtener una lista de respuestas de usuarios
    @Override
    public List<UsuarioResponse> getAllUsers() {
        // Obtener todos los usuarios de la base de datos y mapearlos a respuestas de
        // usuarios
        List<UsuarioResponse> allUsers = userRepository.findAll().stream()
                .map(usuario -> new UsuarioResponse(usuario.getFirstName(), usuario.getLastName(), usuario.getEmail(),
                        usuario.getRoles().toString()))
                .collect(Collectors.toList());
        return allUsers;
    }
}
