package com.example.caramelo.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.caramelo.dto.response.user.UsuarioResponse;
import com.example.caramelo.entities.Usuario;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/resources")
@RequiredArgsConstructor
@CrossOrigin
public class AuthorizationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);

 

    // Endpoint para obtener el perfil del usuario autenticado
    @GetMapping("/perfil")
    public ResponseEntity<UsuarioResponse> miPerfil(@AuthenticationPrincipal Usuario usuario) {
        // Registrar información en el log sobre la llamada al endpoint
        logger.info("## AuthorizationController :: miPerfil");

        // Crear una respuesta de usuario a partir de la información del usuario
        // autenticado
        UsuarioResponse userResponse = new UsuarioResponse(usuario.getFirstName(), usuario.getLastName(),
                usuario.getEmail(), usuario.getRoles().toString());

        // Retornar la respuesta de usuario
        return ResponseEntity.ok(userResponse);
    }
}
