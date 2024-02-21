package com.example.caramelo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.caramelo.dto.request.SignUpRequest;
import com.example.caramelo.dto.request.SigninRequest;
import com.example.caramelo.dto.response.user.JwtAuthenticationResponse;
import com.example.caramelo.service.user.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    // Endpoint para el registro de nuevos usuarios
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        // Invocar al servicio de autenticación para el registro y retornar la respuesta
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    // Endpoint para la autenticación de usuarios existentes
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        // Invocar al servicio de autenticación para el inicio de sesión y retornar la
        // respuesta
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
