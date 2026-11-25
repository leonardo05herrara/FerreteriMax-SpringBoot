package com.ferreteriamax.servicio;

import com.ferreteriamax.modelo.Producto;
import com.ferreteriamax.repositorio.ProductoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Capa de servicio para la logica de negocio de Producto.
 * Separa el controlador del acceso a datos (arquitectura por capas).
 */
@Service
@Transactional
public class ProductoServicio {

    private final ProductoRepositorio repositorio;

    /** Inyeccion de dependencias por constructor (buena practica Spring). */
    public ProductoServicio(ProductoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    /** Retorna todos los productos ordenados alfabeticamente por categoria y nombre. */
    @Transactional(readOnly = true)
    public List<Producto> listarTodos() {
        return repositorio.findAllByOrderByCategoriaAscNombreAsc();
    }

    /** Busca un producto por su identificador unico. */
    @Transactional(readOnly = true)
    public Optional<Producto> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    /** Persiste un producto nuevo o actualiza uno existente. */
    public Producto guardar(Producto producto) {
        return repositorio.save(producto);
    }

    /** Elimina un producto por su ID. */
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}