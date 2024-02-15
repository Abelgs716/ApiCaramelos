package com.example.caramelo.config;

import java.util.Locale;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.caramelo.entities.Caramelo;
import com.example.caramelo.entities.Role;
import com.example.caramelo.entities.Usuario;
import com.example.caramelo.repository.CarameloRepository;
import com.example.caramelo.repository.UserRepository;
import com.github.javafaker.Faker;

@Profile("demo")
@Component
public class InitializationData implements CommandLineRunner {

    @Autowired
    private UserRepository usuarioRepository;
    
    private final boolean borrarCaramelo = false; // Variable para controlar el borrado de datos
    
    @Autowired
    private CarameloRepository carameloRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
    	
    	if (borrarCaramelo) {
    		carameloRepository.deleteAll(); // Borra todos los caramelos existentes
        }
    	
    	try {

            Usuario usuario1 = new Usuario();
            usuario1.setFirstName("Andres");
            usuario1.setLastName("garcia");
            usuario1.setEmail("andres.garcia@example.com");
            usuario1.setPassword(passwordEncoder.encode("password123"));
            usuario1.getRoles().add(Role.ROLE_USER);
            usuarioRepository.save(usuario1);

            Usuario usuario2 = new Usuario();
            usuario2.setFirstName("Abel");
            usuario2.setLastName("Garcia");
            usuario2.setEmail("abelgs717@gmail.com");
            usuario2.setPassword(passwordEncoder.encode("usuario"));
            usuario2.getRoles().add(Role.ROLE_ADMIN);
            usuarioRepository.save(usuario2);

            Usuario usuario3 = new Usuario();
            usuario3.setFirstName("Carolina");
            usuario3.setLastName("suarez");
            usuario3.setEmail("carolina.suarez@example.com");
            usuario3.setPassword(passwordEncoder.encode("password789"));
            usuario3.getRoles().add(Role.ROLE_USER);
            usuarioRepository.save(usuario3);
            
            
            
            
    	}catch(Exception e) {
    		
    	}
    	Faker faker = new Faker(new Locale("es"));
        for (int i = 0; i < 10; i++) { // Generar 10 caramelos ficticios
            Caramelo caramelo = new Caramelo();
            caramelo.setNombre(faker.name().name());
            caramelo.setIngredientes(faker.food().ingredient());
            caramelo.setPeso(faker.number().digits(2));
            caramelo.setColor(faker.color().name());
  
            carameloRepository.save(caramelo);
        }
        
    }
}