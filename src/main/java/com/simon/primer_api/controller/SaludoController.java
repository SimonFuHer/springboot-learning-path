package com.simon.primer_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 1. Le ponemos el uniforme de camarero
public class SaludoController {

    // 2. Definimos la ruta
    @GetMapping("/saludo")
    public String holaMundo() {
        return "¡Hola Simón! Ahora te saludo desde un Controlador limpio y ordenado 🧹✨";
    }
}