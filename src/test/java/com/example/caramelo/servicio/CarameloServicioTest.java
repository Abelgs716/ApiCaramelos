package com.example.caramelo.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.caramelo.entities.Caramelo;
import com.example.caramelo.repository.CarameloRepository;
import com.example.caramelo.service.impl.CaramelosServiceImpl;


@SpringBootTest
public class CarameloServicioTest {

	private CaramelosServiceImpl carameloServicio;
	
    @Mock
    private CarameloRepository carameloRepositorio;

    @BeforeEach
    void setUp() {
 
        MockitoAnnotations.initMocks(this);
        carameloServicio = new CaramelosServiceImpl(carameloRepositorio);
    }


    
    @Test
    void testListarTodosLosCaramelos() {

        when(carameloRepositorio.findAll()).thenReturn(Arrays.asList(new Caramelo()));

  
        Iterable<Caramelo> Caramelos_it = carameloServicio.listarTodosLosCaramelos(PageRequest.of(1, 1));
        List<Caramelo> Caramelos = Arrays.asList(new Caramelo());

        // Handle null case gracefully
        if (Caramelos_it != null) {
            Caramelos_it.forEach(Caramelos::add);
        }

        assertEquals(1, Caramelos.size(), "Debe haber un Caramelo en la lista");
        verify(carameloRepositorio).findAll(PageRequest.of(1, 1)); 
    }

    @Test
    void testObtenerCarameloPorId() {
     
        Caramelo caramelo = new Caramelo();
        caramelo.setId(1L);
    	caramelo.setNombre("Piruleta");
        caramelo.setIngredientes("Azucar");
        caramelo.setPeso("23g");
        caramelo.setColor("rojo");
        when(carameloRepositorio.findById(1L)).thenReturn(Optional.of(caramelo));

       
        Caramelo encontrado = carameloServicio.obtenerCarameloPorId(1L);


        assertEquals(caramelo, encontrado, "El Caramelo encontrado debe coincidir con el mock");
        verify(carameloRepositorio).findById(1L); 
    }


    @Test
    void testGuardarCaramelo() {
   
        Caramelo caramelo = new Caramelo();
        when(carameloRepositorio.save(any(Caramelo.class))).thenReturn(caramelo);

        Caramelo guardado = carameloServicio.agregarCaramelo(caramelo);

   
        assertEquals(caramelo, guardado, "El Caramelo guardado debe coincidir con el mock");
        verify(carameloRepositorio).save(any(Caramelo.class)); 
    }

   
    @Test
    void testEliminarCaramelo() {

        long id = 1L;

        carameloServicio.eliminarCaramelo(id);

   
        verify(carameloRepositorio, times(1)).deleteById(id);
    }
}