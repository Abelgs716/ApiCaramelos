package com.example.caramelo.controlador;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.test.web.servlet.MockMvc;

import com.example.caramelo.controller.CaramelosController;
import com.example.caramelo.entities.Caramelo;
import com.example.caramelo.service.CaramelosService;

@WebMvcTest(CaramelosController.class)
public class CaramelosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CaramelosService caramelosService;

    @Test
    void testListarTodosLosCaramelos() throws Exception {
        // Mocking the service response
        when(caramelosService.listarTodosLosCaramelos(any())).thenReturn(Page.empty());

        mockMvc.perform(get("/api/v1/caramelos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray());

        // Verify that the service method is called
        verify(caramelosService).listarTodosLosCaramelos(any());
    }

    @Test
    void testGetCarameloById() throws Exception {
        // Mocking the service response
        when(caramelosService.obtenerCarameloPorId(1L)).thenReturn(new Caramelo());

        mockMvc.perform(get("/api/v1/caramelos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());

        // Verify that the service method is called
        verify(caramelosService).obtenerCarameloPorId(1L);
    }

    @Test
    void testCreateCaramelo() throws Exception {
        // Mocking the service response
        when(caramelosService.agregarCaramelo(any(Caramelo.class))).thenReturn(new Caramelo());

        mockMvc.perform(post("/api/v1/caramelos")
                .contentType("application/json")
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());

        // Verify that the service method is called
        verify(caramelosService).agregarCaramelo(any(Caramelo.class));
    }

    @Test
    void testUpdateCaramelo() throws Exception {
        // Mocking the service response
        when(caramelosService.actualizarCaramelo(any(Long.class), any(Caramelo.class))).thenReturn(new Caramelo());

        mockMvc.perform(put("/api/v1/caramelos/1")
                .contentType("application/json")
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());

        // Verify that the service method is called
        verify(caramelosService).actualizarCaramelo(any(Long.class), any(Caramelo.class));
    }

    @Test
    void testDeleteCaramelo() throws Exception {
        mockMvc.perform(delete("/api/v1/caramelos/1"))
                .andExpect(status().isOk());

        // Verify that the service method is called
        verify(caramelosService).eliminarCaramelo(1L);
    }
}


