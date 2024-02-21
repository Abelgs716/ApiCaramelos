package com.example.caramelo.entidad;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.example.caramelo.entities.Caramelo;

class CarameloTest {

	@Test
	void crearValoresCorrectoCaramelo() {
		Caramelo caramelo = new Caramelo();
		caramelo.setId(1L);
    	caramelo.setNombre("Piruleta");
            caramelo.setIngredientes("Azucar");
            caramelo.setPeso("23g");
            caramelo.setColor("rojo");

        assertEquals(1L, caramelo.getId(), "El ID no coincide");
        assertEquals("Piruleta", caramelo.getNombre(), "El nombre no coincide");
        assertEquals("Azucar", caramelo.getIngredientes(), "Los ingredientes no coincide");
        assertEquals("23g", caramelo.getPeso(), "El peso no coincide");
        assertEquals("rojo", caramelo.getColor(), "El color no coincide");
	}


}
