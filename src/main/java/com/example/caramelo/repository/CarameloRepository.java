package com.example.caramelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.caramelo.entities.Caramelo;

// Repositorio JPA para la entidad Caramelo
@Repository
public interface CarameloRepository extends JpaRepository<Caramelo, Long> {

}
