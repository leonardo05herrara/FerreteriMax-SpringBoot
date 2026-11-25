package com.ferreteriamax.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * Entidad JPA que representa un producto del catalogo de la ferreteria.
 * Mapeada a la tabla "productos" en MySQL.
 */
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nombre;

    @Size(max = 500)
    @Column(length = 500)
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "El precio no puede ser negativo")
    @Column(nullable = false)
    private Integer precio;

    @Size(max = 10)
    private String icono;

    @Size(max = 200)
    private String imagen;

    @NotBlank(message = "La categoria es obligatoria")
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String categoria;

    // Constructor vacio requerido por JPA
    public Producto() {}

    public Producto(String nombre, String descripcion, Integer precio,
                    String icono, String imagen, String categoria) {
        this.nombre      = nombre;
        this.descripcion = descripcion;
        this.precio      = precio;
        this.icono       = icono;
        this.imagen      = imagen;
        this.categoria   = categoria;
    }

    // Getters y setters
    public Long    getId()          { return id; }
    public void    setId(Long id)   { this.id = id; }

    public String  getNombre()              { return nombre; }
    public void    setNombre(String n)      { this.nombre = n; }

    public String  getDescripcion()         { return descripcion; }
    public void    setDescripcion(String d) { this.descripcion = d; }

    public Integer getPrecio()              { return precio; }
    public void    setPrecio(Integer p)     { this.precio = p; }

    public String  getIcono()               { return icono; }
    public void    setIcono(String i)       { this.icono = i; }

    public String  getImagen()              { return imagen; }
    public void    setImagen(String img)    { this.imagen = img; }

    public String  getCategoria()           { return categoria; }
    public void    setCategoria(String c)   { this.categoria = c; }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio + "}";
    }
}