package com.ferreteriamax.repositorio;

import com.ferreteriamax.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para Usuario.
 * Hereda metodos CRUD: save, findById, findAll, deleteById, etc.
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}