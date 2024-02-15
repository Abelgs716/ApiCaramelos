# Caramelo Application
## Documentación
https://documenter.getpostman.com/view/32189101/2s9YyvAfe2

## Descripción
Caramelo es una aplicación para la gestión de caramelos. Permite a los usuarios explorar diferentes tipos de caramelos y realizar operaciones relacionadas con ellos.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes y clases:

### Configuración
- `com.example.caramelo.config.InitializationData`: Clase para la inicialización de datos.
- `com.example.caramelo.config.JwtAuthenticationFilter`: Filtro de autenticación JWT.
- `com.example.caramelo.config.SecurityConfiguration`: Configuración de seguridad.

### Controladores
- `com.example.caramelo.controller.AuthorizationController`: Controlador para autorización.
- `com.example.caramelo.controller.CaramelosController`: Controlador para operaciones relacionadas con caramelos.
- `com.example.caramelo.controller.user.AuthenticationController`: Controlador para autenticación de usuarios.
- `com.example.caramelo.controller.user.AuthorizationAdminController`: Controlador para autorización de administradores.

### DTO (Data Transfer Objects)
#### Solicitudes
- `com.example.caramelo.dto.request.SigninRequest`: DTO para solicitudes de inicio de sesión.
- `com.example.caramelo.dto.request.SignUpRequest`: DTO para solicitudes de registro de usuario.
#### Respuestas
- `com.example.caramelo.dto.response.user.JwtAuthenticationResponse`: DTO para respuestas de autenticación JWT.
- `com.example.caramelo.dto.response.user.UsuarioResponse`: DTO para respuestas de usuario.
- `com.example.caramelo.dto.response.PexelsResponse`: DTO para respuestas de la API de Pexels.

### Entidades
- `com.example.caramelo.entities.Caramelo`: Clase para la entidad Caramelo.
- `com.example.caramelo.entities.Role`: Clase para la entidad Role.
- `com.example.caramelo.entities.Usuario`: Clase para la entidad Usuario.

### Manejo de Errores
- `com.example.caramelo.error.GlobalExceptionHandler`: Manejador global de excepciones.
#### Excepciones
- `com.example.caramelo.error.exception.CarameloNotFoundException`: Excepción para caramelo no encontrado.
- `com.example.caramelo.error.exception.UserNotFoundException`: Excepción para usuario no encontrado.

### Repositorios
- `com.example.caramelo.repository.CarameloRepository`: Repositorio para la entidad Caramelo.
- `com.example.caramelo.repository.UserRepository`: Repositorio para la entidad Usuario.

### Servicios
- `com.example.caramelo.service.CaramelosService`: Interfaz para el servicio de caramelos.
- `com.example.caramelo.service.UserService`: Interfaz para el servicio de usuarios.
#### Implementaciones
- `com.example.caramelo.service.impl.CaramelosServiceImpl`: Implementación del servicio de caramelos.

### Servicios de Usuario
- `com.example.caramelo.service.user.AuthenticationService`: Interfaz para el servicio de autenticación.
- `com.example.caramelo.service.user.JwtService`: Interfaz para el servicio JWT.
#### Implementaciones
- `com.example.caramelo.service.user.impl.AuthenticationServiceImpl`: Implementación del servicio de autenticación.
- `com.example.caramelo.service.user.impl.JwtServiceImpl`: Implementación del servicio JWT.
- `com.example.caramelo.service.user.impl.UserServiceImpl`: Implementación del servicio de usuario.

## Contribuyendo
Si deseas contribuir a este proyecto, por favor sigue estas instrucciones:
1. Haz un fork del repositorio
2. Crea una rama para tu funcionalidad (`git checkout -b feature/NuevaFuncionalidad`)
3. Haz tus cambios y commitea (`git commit -am 'Agrega nueva funcionalidad'`)
4. Sube los cambios a tu repositorio (`git push origin feature/NuevaFuncionalidad`)
5. Abre un Pull Request
