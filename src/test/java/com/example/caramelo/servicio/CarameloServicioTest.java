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

        // Inicializar los mocks antes de cada prueba
        MockitoAnnotations.initMocks(this);
        carameloServicio = new CaramelosServiceImpl(carameloRepositorio);
    }

    @Test
    void testListarTodosLosCaramelos() {

        // Configurar el comportamiento del mock
        when(carameloRepositorio.findAll()).thenReturn(Arrays.asList(new Caramelo()));

        // Llamar al método del servicio
        Iterable<Caramelo> Caramelos_it = carameloServicio.listarTodosLosCaramelos(PageRequest.of(1, 1));
        List<Caramelo> Caramelos = Arrays.asList(new Caramelo());

        // Manejar el caso de nulo de manera segura
        if (Caramelos_it != null) {
            Caramelos_it.forEach(Caramelos::add);
        }

        // Verificar el resultado y las interacciones del mock
        assertEquals(1, Caramelos.size(), "Debe haber un Caramelo en la lista");
        verify(carameloRepositorio).findAll(PageRequest.of(1, 1));
    }

    @Test
    void testObtenerCarameloPorId() {

        // Configurar el objeto Caramelo y el comportamiento del mock
        Caramelo caramelo = new Caramelo();
        caramelo.setId(1L);
        caramelo.setNombre("Piruleta");
        caramelo.setIngredientes("Azucar");
        caramelo.setPeso("23g");
        caramelo.setColor("rojo");
        when(carameloRepositorio.findById(1L)).thenReturn(Optional.of(caramelo));

        // Llamar al método del servicio
        Caramelo encontrado = carameloServicio.obtenerCarameloPorId(1L);

        // Verificar el resultado y las interacciones del mock
        assertEquals(caramelo, encontrado, "El Caramelo encontrado debe coincidir con el mock");
        verify(carameloRepositorio).findById(1L);
    }

    @Test
    void testGuardarCaramelo() {

        // Configurar el objeto Caramelo y el comportamiento del mock
        Caramelo caramelo = new Caramelo();
        when(carameloRepositorio.save(any(Caramelo.class))).thenReturn(caramelo);

        // Llamar al método del servicio
        Caramelo guardado = carameloServicio.agregarCaramelo(caramelo);

        // Verificar el resultado y las interacciones del mock
        assertEquals(caramelo, guardado, "El Caramelo guardado debe coincidir con el mock");
        verify(carameloRepositorio).save(any(Caramelo.class));
    }

    @Test
    void testEliminarCaramelo() {

        // Configurar el ID
        long id = 1L;

        // Llamar al método del servicio
        carameloServicio.eliminarCaramelo(id);

        // Verificar las interacciones del mock
        verify(carameloRepositorio, times(1)).deleteById(id);
    }
}
