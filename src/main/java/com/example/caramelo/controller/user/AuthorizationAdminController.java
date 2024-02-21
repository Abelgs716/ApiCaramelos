package com.example.caramelo.controller.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.caramelo.dto.response.user.UsuarioResponse;
import com.example.caramelo.entities.Usuario;
import com.example.caramelo.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class AuthorizationAdminController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationAdminController.class);

    @Autowired
    private UserService userService;

    // Endpoint para obtener la lista de usuarios, solo accesible por roles con
    // autoridad 'ROLE_ADMIN'
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<UsuarioResponse>> showUsers() {
        // Registrar información en el log sobre la llamada al endpoint
        logger.info("## AuthorizationAdminController :: showUsers");

        // Obtener la lista de usuarios utilizando el servicio de usuario
        List<UsuarioResponse> userList = userService.getAllUsers();

        // Retornar la lista de usuarios como respuesta
        return ResponseEntity.ok(userList);
    }
}
