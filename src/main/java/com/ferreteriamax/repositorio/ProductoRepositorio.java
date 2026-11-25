package com.ferreteriamax.repositorio;

import com.ferreteriamax.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio JPA para Producto.
 * Spring Data genera automaticamente la implementacion en tiempo de ejecucion.
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    /** Retorna todos los productos ordenados por categoria y nombre. */
    List<Producto> findAllByOrderByCategoriaAscNombreAsc();
}