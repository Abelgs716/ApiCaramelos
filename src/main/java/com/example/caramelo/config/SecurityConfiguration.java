package com.example.caramelo.config;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.caramelo.entities.Role;
import com.example.caramelo.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        // Permitir acceso sin autenticación a rutas específicas
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        // Definir permisos para operaciones CRUD en caramelos
                        .requestMatchers(HttpMethod.GET, "/api/v1/caramelos/**")
                        .hasAnyAuthority(Role.ROLE_USER.toString(), Role.ROLE_ADMIN.toString())
                        .requestMatchers(HttpMethod.POST, "/api/v1/caramelos/**")
                        .hasAuthority(Role.ROLE_ADMIN.toString())
                        .requestMatchers(HttpMethod.PUT, "/api/v1/caramelos/**")
                        .hasAuthority(Role.ROLE_ADMIN.toString())
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/caramelos/**")
                        .hasAuthority(Role.ROLE_ADMIN.toString())
                        // Definir permisos para operaciones en usuarios
                        .requestMatchers("/api/v1/users/**").hasAuthority("ROLE_ADMIN")
                        // Restringir acceso a otras rutas a usuarios autenticados
                        .anyRequest().authenticated())
                // Configurar la gestión de sesiones como 'sin estado'
                .sessionManagement(manager -> manager.sessionCreationPolicy(STATELESS))
                // Configurar la política de CORS por defecto
                .cors(Customizer.withDefaults())
                // Configurar el proveedor de autenticación y agregar el filtro JWT
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        // Configurar el proveedor de autenticación basado en DAO
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService.userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        // Obtener el administrador de autenticación desde la configuración
        return config.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        // Configurar el origen de configuración CORS
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
