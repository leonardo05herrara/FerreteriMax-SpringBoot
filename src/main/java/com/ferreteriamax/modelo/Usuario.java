package com.ferreteriamax.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * Entidad JPA que representa un usuario del sistema.
 * Mapeada a la tabla "usuarios" en MySQL.
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Formato de correo invalido")
    @Size(max = 150)
    @Column(nullable = false, unique = true, length = 150)
    private String correo;

    @Size(max = 20)
    private String telefono;

    @Size(max = 200)
    private String direccion;

    // Constructor vacio requerido por JPA
    public Usuario() {}

    public Usuario(String nombre, String correo, String telefono, String direccion) {
        this.nombre    = nombre;
        this.correo    = correo;
        this.telefono  = telefono;
        this.direccion = direccion;
    }

    // Getters y setters
    public Long   getId()            { return id; }
    public void   setId(Long id)     { this.id = id; }

    public String getNombre()           { return nombre; }
    public void   setNombre(String n)   { this.nombre = n; }

    public String getCorreo()           { return correo; }
    public void   setCorreo(String c)   { this.correo = c; }

    public String getTelefono()         { return telefono; }
    public void   setTelefono(String t) { this.telefono = t; }

    public String getDireccion()        { return direccion; }
    public void   setDireccion(String d){ this.direccion = d; }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre='" + nombre + "', correo='" + correo + "'}";
    }
}