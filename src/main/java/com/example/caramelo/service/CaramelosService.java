package com.example.caramelo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.caramelo.entities.Caramelo;

// Interfaz para proporcionar servicios relacionados con los caramelos
public interface CaramelosService {

	Caramelo agregarCaramelo(Caramelo caramelo); // Agregar un nuevo caramelo

	Page<Caramelo> listarTodosLosCaramelos(Pageable pageable); // Obtener todos los caramelos paginados

	Caramelo obtenerCarameloPorId(Long id); // Obtener un caramelo por su ID

	Caramelo actualizarCaramelo(Long id, Caramelo detallesCaramelo); // Actualizar los detalles de un caramelo existente

	void eliminarCaramelo(Long id); // Eliminar un caramelo por su ID
	
	 Page<Caramelo> filtrarPorPeso(String peso, Pageable pageable);
	 Page<Caramelo> filtrarPorIngredientes(String ingredientes, Pageable pageable);
	 Page<Caramelo> filtrarPorPesoEIngredientes(String peso, String ingredientes, Pageable pageable);

	   

}
