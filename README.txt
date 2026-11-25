========================================================
  FERRETERIA MAX - Modulo Web con Spring Boot
  Evidencia: GA7-220501096-AA3-EV01
  Aprendiz:  Leonardo Herrera
  Fecha:     2026-11-25
  SENA - Analisis y Desarrollo de Software
========================================================

DESCRIPCION
-----------
Aplicacion web desarrollada con el framework Spring Boot 3.1.
Implementa un CRUD completo de Productos y Usuarios usando:
  - Spring MVC (Controladores @Controller)
  - Spring Data JPA + Hibernate (Repositorios)
  - Thymeleaf (Motor de plantillas HTML)
  - MySQL (Base de datos relacional)
  - Bootstrap 5 (Interfaz de usuario)

ESTRUCTURA DEL PROYECTO
-----------------------
src/main/java/com/ferreteriamax/
  FerreteriMaxApplication.java        -> Clase principal Spring Boot
  modelo/
    Producto.java                     -> Entidad JPA productos
    Usuario.java                      -> Entidad JPA usuarios
  repositorio/
    ProductoRepositorio.java          -> Spring Data JPA
    UsuarioRepositorio.java           -> Spring Data JPA
  servicio/
    ProductoServicio.java             -> Logica de negocio
    UsuarioServicio.java              -> Logica de negocio
  controlador/
    InicioControlador.java            -> Ruta "/"
    ProductoControlador.java          -> CRUD /productos
    UsuarioControlador.java           -> CRUD /usuarios
src/main/resources/
  application.properties             -> Configuracion BD
  templates/
    index.html                       -> Pagina principal
    productos/lista.html             -> Listado productos
    productos/formulario.html        -> Formulario crear/editar
    usuarios/lista.html              -> Listado usuarios
    usuarios/formulario.html         -> Formulario crear/editar

REQUISITOS
----------
- Java 17+
- Maven 3.8+
- MySQL 8.x corriendo con la base de datos "ferreteria_max"
- Ejecutar primero el SQL de EV01: ferreteriamax.sql

COMO EJECUTAR
-------------
1. Abrir terminal en la carpeta del proyecto
2. mvn spring-boot:run
3. Abrir navegador en http://localhost:8080

RUTAS PRINCIPALES
-----------------
  /             -> Pagina de inicio
  /productos    -> CRUD de productos
  /usuarios     -> CRUD de usuarios