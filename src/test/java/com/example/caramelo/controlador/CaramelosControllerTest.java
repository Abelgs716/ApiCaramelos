package com.example.caramelo.controlador;

import com.example.caramelo.controller.CaramelosController;
import com.example.caramelo.entities.Caramelo;
import com.example.caramelo.service.CaramelosService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CaramelosControllerTest {

    @Mock
    private CaramelosService caramelosService;

    @InjectMocks
    private CaramelosController caramelosController;

    @Test
    void testGetCarameloById() {
        // Arrange
        Long carameloId = 1L;
        when(caramelosService.obtenerCarameloPorId(carameloId)).thenReturn(Optional.of(new Caramelo()).get());

        // Act
        Caramelo result = caramelosController.getCarameloById(carameloId);

        // Assert
        verify(caramelosService, times(1)).obtenerCarameloPorId(carameloId);
        verifyNoMoreInteractions(caramelosService);
    }

    @Test
    void testCreateCaramelo() {
        // Arrange
        Caramelo carameloToCreate = new Caramelo();
        when(caramelosService.agregarCaramelo(carameloToCreate)).thenReturn(new Caramelo());

        // Act
        Caramelo result = caramelosController.createCaramelo(carameloToCreate);

        // Assert
        verify(caramelosService, times(1)).agregarCaramelo(carameloToCreate);
        verifyNoMoreInteractions(caramelosService);
    }

    @Test
    void testUpdateCaramelo() {
        // Arrange
        Long carameloId = 1L;
        Caramelo carameloDetails = new Caramelo();
        when(caramelosService.actualizarCaramelo(carameloId, carameloDetails)).thenReturn(new Caramelo());

        // Act
        Caramelo result = caramelosController.updateCaramelo(carameloId, carameloDetails);

        // Assert
        verify(caramelosService, times(1)).actualizarCaramelo(carameloId, carameloDetails);
        verifyNoMoreInteractions(caramelosService);
    }

    @Test
    void testDeleteCaramelo() {
        // Arrange
        Long carameloId = 1L;

        // Act
        caramelosController.deleteCaramelo(carameloId);

        // Assert
        verify(caramelosService, times(1)).eliminarCaramelo(carameloId);
        verifyNoMoreInteractions(caramelosService);
    }
}
