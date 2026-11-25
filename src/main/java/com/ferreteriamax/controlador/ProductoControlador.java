package com.ferreteriamax.controlador;

import com.ferreteriamax.modelo.Producto;
import com.ferreteriamax.servicio.ProductoServicio;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador Spring MVC para el CRUD de Productos.
 * Maneja las rutas GET y POST del modulo de productos.
 */
@Controller
@RequestMapping("/productos")
public class ProductoControlador {

    private final ProductoServicio servicio;

    public ProductoControlador(ProductoServicio servicio) {
        this.servicio = servicio;
    }

    /** Lista todos los productos. GET /productos */
    @GetMapping
    public String listar(Model modelo) {
        modelo.addAttribute("productos", servicio.listarTodos());
        return "productos/lista";
    }

    /** Muestra formulario para nuevo producto. GET /productos/nuevo */
    @GetMapping("/nuevo")
    public String formularioNuevo(Model modelo) {
        modelo.addAttribute("producto", new Producto());
        modelo.addAttribute("titulo", "Nuevo Producto");
        return "productos/formulario";
    }

    /** Muestra formulario para editar producto existente. GET /productos/editar/{id} */
    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model modelo) {
        Producto producto = servicio.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + id));
        modelo.addAttribute("producto", producto);
        modelo.addAttribute("titulo", "Editar Producto");
        return "productos/formulario";
    }

    /** Guarda (crea o actualiza) un producto. POST /productos/guardar */
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Producto producto,
                          BindingResult resultado,
                          Model modelo,
                          RedirectAttributes flash) {
        if (resultado.hasErrors()) {
            // Mantiene el titulo correcto si hay errores de validacion
            modelo.addAttribute("titulo",
                    producto.getId() == null ? "Nuevo Producto" : "Editar Producto");
            return "productos/formulario";
        }
        boolean esNuevo = (producto.getId() == null);
        servicio.guardar(producto);
        flash.addFlashAttribute("msg",
                esNuevo ? "Producto creado exitosamente." : "Producto actualizado exitosamente.");
        return "redirect:/productos";
    }

    /** Elimina un producto por ID. GET /productos/eliminar/{id} */
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
        servicio.eliminar(id);
        flash.addFlashAttribute("msg", "Producto eliminado exitosamente.");
        return "redirect:/productos";
    }
}