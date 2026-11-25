package com.ferreteriamax.controlador;

import com.ferreteriamax.modelo.Usuario;
import com.ferreteriamax.servicio.UsuarioServicio;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador Spring MVC para el CRUD de Usuarios.
 */
@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private final UsuarioServicio servicio;

    public UsuarioControlador(UsuarioServicio servicio) {
        this.servicio = servicio;
    }

    /** Lista todos los usuarios. GET /usuarios */
    @GetMapping
    public String listar(Model modelo) {
        modelo.addAttribute("usuarios", servicio.listarTodos());
        return "usuarios/lista";
    }

    /** Formulario para nuevo usuario. GET /usuarios/nuevo */
    @GetMapping("/nuevo")
    public String formularioNuevo(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        modelo.addAttribute("titulo", "Nuevo Usuario");
        return "usuarios/formulario";
    }

    /** Formulario para editar usuario. GET /usuarios/editar/{id} */
    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model modelo) {
        Usuario usuario = servicio.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + id));
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("titulo", "Editar Usuario");
        return "usuarios/formulario";
    }

    /** Guarda (crea o actualiza) un usuario. POST /usuarios/guardar */
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Usuario usuario,
                          BindingResult resultado,
                          Model modelo,
                          RedirectAttributes flash) {
        if (resultado.hasErrors()) {
            modelo.addAttribute("titulo",
                    usuario.getId() == null ? "Nuevo Usuario" : "Editar Usuario");
            return "usuarios/formulario";
        }
        boolean esNuevo = (usuario.getId() == null);
        servicio.guardar(usuario);
        flash.addFlashAttribute("msg",
                esNuevo ? "Usuario creado exitosamente." : "Usuario actualizado exitosamente.");
        return "redirect:/usuarios";
    }

    /** Elimina un usuario por ID. GET /usuarios/eliminar/{id} */
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
        servicio.eliminar(id);
        flash.addFlashAttribute("msg", "Usuario eliminado exitosamente.");
        return "redirect:/usuarios";
    }
}