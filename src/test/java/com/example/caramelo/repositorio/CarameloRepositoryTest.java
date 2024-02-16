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

@ExtendWith(MockitoExtension.class)
public class CarameloRepositoryTest {

    @Mock
    private CarameloRepository carameloRepository;

    @Test
    void testFindById() {
       
        Long carameloId = 1L;
        Caramelo expectedCaramelo = new Caramelo();
        when(carameloRepository.findById(carameloId)).thenReturn(Optional.of(expectedCaramelo));

        Optional<Caramelo> result = carameloRepository.findById(carameloId);


        assertEquals(expectedCaramelo, result.orElse(null));


        verify(carameloRepository, times(1)).findById(carameloId);
        verifyNoMoreInteractions(carameloRepository);
    }

    @Test
    void testSave() {
       
        Caramelo carameloToSave = new Caramelo();
        when(carameloRepository.save(carameloToSave)).thenReturn(carameloToSave);

        Caramelo result = carameloRepository.save(carameloToSave);

        assertEquals(carameloToSave, result);

        verify(carameloRepository, times(1)).save(carameloToSave);
        verifyNoMoreInteractions(carameloRepository);
    }


}
