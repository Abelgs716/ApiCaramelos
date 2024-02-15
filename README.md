# Caramelo Application
## Documentación
https://documenter.getpostman.com/view/32189101/2s9YyvAfe2
## Análisis Caso de uso
## Descripción del Proyecto Tienda de Jabones

La Tienda de Jabones es un proyecto apasionante diseñado para brindar a los amantes del cuidado personal una experiencia única al explorar y adquirir una amplia variedad de jabones artesanales. La tienda se concibe como un espacio virtual interactivo donde los clientes pueden acceder a diversas funcionalidades destinadas a satisfacer sus necesidades de cuidado personal y bienestar.

### Componente Central

El componente central de la tienda es un catálogo diverso de jabones artesanales, elaborados con ingredientes naturales y diseñados para proporcionar beneficios específicos para la piel. Los usuarios registrados pueden explorar este catálogo.

### Identificación de Actores:

1. **Cliente Registrado:** Persona que ha creado una cuenta en la tienda y tiene acceso a contenido exclusivo.
2. **Visitante:** Persona que accede a la tienda sin registrarse y no tiene acceso a nada.
3. **Administrador de la Tienda:** Responsable de gestionar y mantener la tienda. Tiene acceso a herramientas de administración, como la gestión de productos y de clientes.

## Casos de Uso:

### Explorar y Comprar:

**Actor Principal:** Cliente Registrado

**Descripción:** El actor explora el catálogo de jabones, selecciona productos para comprar.

**Precondiciones:** El actor debe estar registrado.

**Postcondiciones:** Se realiza la compra y se actualiza el historial de compras del cliente registrado.

### Análisis Detallado de Caso de Uso: Explorar

**Descripción Detallada:** El cliente registra o visita el catálogo de jabones, selecciona productos para comprar, agrega al carrito de compras.

**Precondiciones:** El cliente debe estar registrado.

**Postcondiciones:** (No especificadas en el texto original).

## Reflexión:

Este análisis resalta la importancia de las funciones clave para la experiencia del cliente, como la exploración fácil del catálogo y la sencillez en el proceso de compra. La necesidad de una interfaz de usuario intuitiva y la calidad de los productos ofrecidos son elementos cruciales. Además, la gestión eficiente del historial de compras del cliente y la atención personalizada son aspectos a considerar en el diseño y desarrollo de la tienda. La retroalimentación y la participación activa de los clientes son esenciales para mejorar continuamente la tienda y garantizar una experiencia de compra satisfactoria.



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
