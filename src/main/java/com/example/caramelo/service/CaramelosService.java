package com.example.caramelo.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.caramelo.entities.Caramelo;

import com.example.caramelo.entities.Usuario;

public interface CaramelosService {

	Caramelo agregarCaramelo(Caramelo Caramelo);

	Page<Caramelo> listarTodosLosCaramelos(Pageable pageable);

	Caramelo obtenerCarameloPorId(Long id);

	Caramelo actualizarCaramelo(Long id, Caramelo Jabon);

	void eliminarCaramelo(Long id);


}