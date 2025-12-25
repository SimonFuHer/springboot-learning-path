package com.simon.primer_api.controller;

import com.simon.primer_api.model.Saludo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    // 1. ESCENARIO A: Si ponen nombre
    @GetMapping("/saludo/{nombre}")
    public Saludo holaMundo(@PathVariable String nombre) {
        return new Saludo("Hola " + nombre, "Simón", "¡Enhorabuena " + nombre + ", tu API ya responde dinámicamente!");
    }

    // 2. ESCENARIO B: Si NO ponen nombre (El "Plan B")
    @GetMapping("/saludo")
    public Saludo saludoDefault() {
        return new Saludo("Hola Desconocido", "Simón", "No me has dicho tu nombre, ¡pero te saludo igual!");
    }
}