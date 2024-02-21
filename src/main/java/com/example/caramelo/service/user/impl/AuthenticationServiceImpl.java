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

// Implementación de la interfaz AuthenticationService que proporciona servicios relacionados con la autenticación de usuarios
@Builder
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // Constructor para la inyección de dependencias
    public AuthenticationServiceImpl(UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        // Verificar si el correo electrónico ya está en uso
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already in use.");
        }

        // Crear un nuevo usuario y asignarle un rol de usuario
        Usuario user = new Usuario();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        userRepository.save(user);

        // Generar un token JWT para el usuario registrado
        String jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        // Autenticar al usuario utilizando Spring Security AuthenticationManager
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        // Obtener el usuario autenticado
        Usuario user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

        // Generar un token JWT para el usuario autenticado
        String jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
