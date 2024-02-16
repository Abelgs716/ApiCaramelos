package com.example.caramelo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.caramelo.entities.Caramelo;
import com.example.caramelo.entities.Usuario;
import com.example.caramelo.error.exception.CarameloNotFoundException;
import com.example.caramelo.repository.CarameloRepository;
import com.example.caramelo.service.CaramelosService;

import jakarta.validation.Valid;

@Service
public class CaramelosServiceImpl implements CaramelosService {


    private final CarameloRepository CarameloRepository;

    public CaramelosServiceImpl(CarameloRepository repository) {
    	this.CarameloRepository = repository;
    }
    
    @Override
    public Caramelo agregarCaramelo(@Valid Caramelo Caramelo) {
        return CarameloRepository.save(Caramelo);
    }

    @Override
    public Caramelo obtenerCarameloPorId(Long id) {
        return CarameloRepository.findById(id)
                .orElseThrow(() -> new CarameloNotFoundException("Caramelo no encontrado"));
    }

    @Override
    public Caramelo actualizarCaramelo(Long id, @Valid Caramelo detallesCaramelo) {
        Caramelo Caramelo = obtenerCarameloPorId(id);
        Caramelo.setNombre(detallesCaramelo.getNombre());
        Caramelo.setIngredientes(detallesCaramelo.getIngredientes());
        Caramelo.setPeso(detallesCaramelo.getPeso());
        Caramelo.setColor(detallesCaramelo.getColor());
        

        return CarameloRepository.save(Caramelo);
    }

    @Override
    public void eliminarCaramelo(Long id) {
        CarameloRepository.deleteById(id);
    }

	@Override
	public Page<Caramelo> listarTodosLosCaramelos(Pageable pageable) {
		 return CarameloRepository.findAll(pageable);
	}





}
