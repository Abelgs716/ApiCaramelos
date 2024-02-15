package com.example.caramelo.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.caramelo.entities.Caramelo;
import com.example.caramelo.service.CaramelosService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;


	@RestController
	@RequestMapping("/api/v1/caramelos")
	public class CaramelosController {

    	private static final Logger logger = LoggerFactory.getLogger(CaramelosController.class);

	    @Autowired
	    private CaramelosService caramelosService;
	    
	  

	    // Endpoint para obtener un listado de caramelos, accesible solo por ROLE_USER
	    @GetMapping
	    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
	    public ResponseEntity<Page<Caramelo>> listarTodosLosCaramelos(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        
	        logger.info("CaramelosController :: listarTodosLosCaramelos");
	        Pageable pageable = PageRequest.of(page, size);
	        Page<Caramelo> caramelos = caramelosService.listarTodosLosCaramelos(pageable);
	        
	   
	        
	        return new ResponseEntity<>(caramelos, HttpStatus.OK);
	    }
	    
	 // Leer un caramelo por ID
	    @GetMapping("/{id}")
	    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
	    public Caramelo getCarameloById(@PathVariable Long id) {
	        return caramelosService.obtenerCarameloPorId(id);
	    }

	    // CRUD endpoints, accesibles solo por ROLE_ADMIN
	    // Crear un nuevo caramelo
	    @PostMapping
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public Caramelo createCaramelo(@Valid @RequestBody Caramelo caramelo) {
	    
	        return caramelosService.agregarCaramelo(caramelo);
	    }

	    // Actualizar un caramelo
	    @PutMapping("/{id}")
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public Caramelo updateCaramelo(@PathVariable Long id, @RequestBody Caramelo carameloDetails) {
	        return caramelosService.actualizarCaramelo(id, carameloDetails);
	    }

	    // Eliminar un caramelo
	    @DeleteMapping("/{id}")
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public void deleteCaramelo(@PathVariable Long id) {
	    	caramelosService.eliminarCaramelo(id);
	    }
	    
	  
	    }
	    
	    
	    
	