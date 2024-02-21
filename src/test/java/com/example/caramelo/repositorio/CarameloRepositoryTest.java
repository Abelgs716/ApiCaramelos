package com.example.caramelo.repositorio;

import com.example.caramelo.entities.Caramelo;
import com.example.caramelo.repository.CarameloRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// Configuración para usar Mockito con JUnit 5
@ExtendWith(MockitoExtension.class)
public class CarameloRepositoryTest {

    // Mock del repositorio de Caramelos
    @Mock
    private CarameloRepository carameloRepository;

    // Test para el método findById
    @Test
    void testFindById() {
        // ID de un caramelo
        Long carameloId = 1L;
        // Caramelo esperado
        Caramelo expectedCaramelo = new Caramelo();

        // Configuración del mock para que retorne un Optional con el Caramelo esperado
        when(carameloRepository.findById(carameloId)).thenReturn(Optional.of(expectedCaramelo));

        // Llamada al método
        Optional<Caramelo> result = carameloRepository.findById(carameloId);

        // Verificación de que el resultado coincide con el Caramelo esperado
        assertEquals(expectedCaramelo, result.orElse(null));

        // Verificación de que el método findById fue llamado exactamente una vez con el
        // ID específico
        verify(carameloRepository, times(1)).findById(carameloId);
        // Verificación de que no hay más interacciones con el repositorio después de
        // las esperadas
        verifyNoMoreInteractions(carameloRepository);
    }

    // Test para el método save
    @Test
    void testSave() {
        // Caramelo a guardar
        Caramelo carameloToSave = new Caramelo();

        // Configuración del mock para que retorne el mismo Caramelo cuando se llama al
        // método save
        when(carameloRepository.save(carameloToSave)).thenReturn(carameloToSave);

        // Llamada al método
        Caramelo result = carameloRepository.save(carameloToSave);

        // Verificación de que el resultado coincide con el Caramelo de entrada
        assertEquals(carameloToSave, result);

        // Verificación de que el método save fue llamado exactamente una vez con el
        // Caramelo específico
        verify(carameloRepository, times(1)).save(carameloToSave);
        // Verificación de que no hay más interacciones con el repositorio después de
        // las esperadas
        verifyNoMoreInteractions(carameloRepository);
    }
}
