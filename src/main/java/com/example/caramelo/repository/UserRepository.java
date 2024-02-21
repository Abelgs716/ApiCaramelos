package com.example.caramelo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.caramelo.entities.Usuario;

// Repositorio JPA para la entidad Usuario
@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email); // Buscar usuario por correo electrónico

	Optional<Usuario> findById(Long id); // Buscar usuario por ID

	Boolean existsByEmail(String email); // Verificar si existe un usuario con el correo electrónico proporcionado
}
