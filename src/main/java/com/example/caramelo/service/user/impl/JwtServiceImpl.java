package com.example.caramelo.service.user.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.caramelo.dto.request.SignUpRequest;
import com.example.caramelo.dto.request.SigninRequest;
import com.example.caramelo.dto.response.user.JwtAuthenticationResponse;
import com.example.caramelo.entities.Role;
import com.example.caramelo.entities.Usuario;
import com.example.caramelo.repository.UserRepository;
import com.example.caramelo.service.user.AuthenticationService;
import com.example.caramelo.service.user.JwtService;

import lombok.Builder;

// Implementación de la interfaz AuthenticationService que proporciona servicios de autenticación
@Builder
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // Constructor que inyecta las dependencias necesarias
    public AuthenticationServiceImpl(UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    // Método para registrar un nuevo usuario y devolver un token JWT
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already in use.");
        }

        // Crear un nuevo usuario
        Usuario user = new Usuario();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        userRepository.save(user);

        // Generar un token JWT
        String jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    // Método para autenticar a un usuario existente y devolver un token JWT
    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        // Autenticar al usuario utilizando el AuthenticationManager
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        // Obtener el usuario autenticado de la base de datos
        Usuario user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

        // Generar un token JWT
        String jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
