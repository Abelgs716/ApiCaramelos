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
    // Variable para controlar el borrado de datos
    private final boolean borrarCaramelo = false;

    @Autowired
    private CarameloRepository carameloRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        // Borrar todos los caramelos existentes si la variable borrarCaramelo es true
        if (borrarCaramelo) {
            carameloRepository.deleteAll();
        }

        try {
            // Crear y guardar un usuario de ejemplo
            Usuario usuario1 = new Usuario();
            usuario1.setFirstName("Andres");
            usuario1.setLastName("Garcia");
            usuario1.setEmail("andres.garcia@example.com");
            usuario1.setPassword(passwordEncoder.encode("password123"));
            usuario1.getRoles().add(Role.ROLE_USER);
            usuarioRepository.save(usuario1);

            // Crear y guardar un segundo usuario de ejemplo
            Usuario usuario2 = new Usuario();
            usuario2.setFirstName("Abel");
            usuario2.setLastName("Garcia");
            usuario2.setEmail("abelgs717@gmail.com");
            usuario2.setPassword(passwordEncoder.encode("usuario"));
            usuario2.getRoles().add(Role.ROLE_ADMIN);
            usuarioRepository.save(usuario2);

            // Crear y guardar un tercer usuario de ejemplo
            Usuario usuario3 = new Usuario();
            usuario3.setFirstName("Carolina");
            usuario3.setLastName("Suarez");
            usuario3.setEmail("carolina.suarez@example.com");
            usuario3.setPassword(passwordEncoder.encode("password789"));
            usuario3.getRoles().add(Role.ROLE_USER);
            usuarioRepository.save(usuario3);

        } catch (Exception e) {
            // Manejar excepciones aquí si es necesario
        }

        // Usar Faker para generar 10 caramelos ficticios
        Faker faker = new Faker(new Locale("es"));
        for (int i = 0; i < 10; i++) {
            Caramelo caramelo = new Caramelo();
            caramelo.setNombre(faker.name().name());
            caramelo.setIngredientes(faker.food().ingredient());
            caramelo.setPeso(faker.number().digits(2));
            caramelo.setColor(faker.color().name());

            carameloRepository.save(caramelo);
        }
    }
}
