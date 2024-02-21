package com.example.caramelo.repositorio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.caramelo.entities.Caramelo;
import com.example.caramelo.repository.CarameloRepository;

// Configuración para ejecutar pruebas específicas de JPA
@DataJpaTest
public class CarameloRepositorioTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarameloRepository carameloRepositorio;

    private Caramelo caramelo;

    // Configuración previa a cada test
    @BeforeEach
    void setUp() {
        caramelo = new Caramelo();
        caramelo.setNombre("Piruleta");
        caramelo.setIngredientes("Azucar");
        caramelo.setPeso("23g");
        caramelo.setColor("rojo");
        entityManager.persist(caramelo);
        entityManager.flush();
    }

    // Test para el método save del repositorio
    @Test
    public void testGuardarCaramelo() {
        // Arrange
        Caramelo nuevoCaramelo = new Caramelo();
        nuevoCaramelo.setNombre("Piruleta2");
        nuevoCaramelo.setIngredientes("Azucar2");
        nuevoCaramelo.setPeso("232g");
        nuevoCaramelo.setColor("rojo2");

        // Act
        Caramelo guardado = carameloRepositorio.save(nuevoCaramelo);

        // Assert
        assertThat(guardado).hasFieldOrPropertyWithValue("nombre", "Piruleta2");
    }

    // Test para el método findById del repositorio
    @Test
    public void testBuscarCarameloPorId() {
        // Act
        Caramelo encontrado = carameloRepositorio.findById(caramelo.getId()).orElse(null);

        // Assert
        assertThat(encontrado).isEqualTo(caramelo);
    }

    // Test para el método findAll del repositorio
    @Test
    public void testListarCaramelos() {
        // Act
        List<Caramelo> caramelos = (List<Caramelo>) carameloRepositorio.findAll();

        // Assert
        assertThat(caramelos).isNotEmpty();
        assertThat(caramelos).contains(caramelo);
    }

    // Test para el método delete del repositorio
    @Test
    public void testEliminarCaramelo() {
        // Act
        carameloRepositorio.delete(caramelo);
        Caramelo eliminado = carameloRepositorio.findById(caramelo.getId()).orElse(null);

        // Assert
        assertThat(eliminado).isNull();
    }
}
