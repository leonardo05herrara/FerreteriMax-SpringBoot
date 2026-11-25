package com.ferreteriamax.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador de la pagina de inicio.
 * Redirige "/" a la vista principal del modulo.
 */
@Controller
public class InicioControlador {

    @GetMapping("/")
    public String inicio() {
        return "index";
    }
}