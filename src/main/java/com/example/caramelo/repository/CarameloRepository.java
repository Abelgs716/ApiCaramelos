package com.example.caramelo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.caramelo.entities.Caramelo;

// Repositorio JPA para la entidad Caramelo
@Repository
public interface CarameloRepository extends JpaRepository<Caramelo, Long> {

    Page<Caramelo> findByPesoContainingIgnoreCase(String peso, Pageable pageable);

    Page<Caramelo> findByIngredientesContainingIgnoreCase(String ingredientes, Pageable pageable);

    Page<Caramelo> findByPesoContainingIgnoreCaseAndIngredientesContainingIgnoreCase(String peso, String ingredientes, Pageable pageable);


}
