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

@DataJpaTest
public class CarameloRepositorioTest {


 @Autowired
 private TestEntityManager entityManager;


 @Autowired
 private CarameloRepository CarameloRepositorio;


 private Caramelo caramelo;


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

 @Test
 public void testGuardarCaramelo() {

     Caramelo nuevoCaramelo = new Caramelo();
     nuevoCaramelo.setNombre("Piruleta2");
     nuevoCaramelo.setIngredientes("Azucar2");
     nuevoCaramelo.setPeso("232g");
     nuevoCaramelo.setColor("rojo2");
     Caramelo guardado = CarameloRepositorio.save(nuevoCaramelo);

     assertThat(guardado).hasFieldOrPropertyWithValue("nombre", "Piruleta2");
 }

 @Test
 public void testBuscarCarameloPorId() {
    
     Caramelo encontrado = CarameloRepositorio.findById(caramelo.getId()).orElse(null);
     assertThat(encontrado).isEqualTo(caramelo);
 }


 @Test
 public void testListarCaramelos() {
   
     List<Caramelo> Caramelos = (List<Caramelo>) CarameloRepositorio.findAll();
     assertThat(Caramelos).isNotEmpty();
     assertThat(Caramelos).contains(caramelo);
 }


 @Test
 public void testEliminarCaramelo() {
    
     CarameloRepositorio.delete(caramelo);
     Caramelo eliminado = CarameloRepositorio.findById(caramelo.getId()).orElse(null);
     assertThat(eliminado).isNull();
 }
}