package com.ferreteriamax.servicio;

import com.ferreteriamax.modelo.Usuario;
import com.ferreteriamax.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Capa de servicio para la logica de negocio de Usuario.
 */
@Service
@Transactional
public class UsuarioServicio {

    private final UsuarioRepositorio repositorio;

    public UsuarioServicio(UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarTodos() {
        return repositorio.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    public Usuario guardar(Usuario usuario) {
        return repositorio.save(usuario);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}