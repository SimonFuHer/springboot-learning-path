package com.simon.primer_api.controller;

import com.simon.primer_api.model.Saludo;
import com.simon.primer_api.service.SaludoService; // Importamos el servicio
import org.springframework.web.bind.annotation.*;

@RestController
public class SaludoController {

    // 1. Declaramos que necesitamos al Chef
    private final SaludoService saludoService;

    // 2. CONSTRUCTOR: Spring verá esto y nos pasará el servicio automáticamente
    public SaludoController(SaludoService saludoService) {
        this.saludoService = saludoService;
    }

    // --- RUTAS ---

    @GetMapping("/saludo/{nombre}")
    public Saludo holaMundo(@PathVariable String nombre) {
        // YA NO creamos el objeto aquí con 'new'.
        // Le pedimos al servicio que lo haga.
        return saludoService.generarSaludo(nombre);
    }

    @PostMapping("/saludo")
    public Saludo guardarSaludo(@RequestBody Saludo saludo) {
        // Delegamos la lógica al servicio
        return saludoService.procesarSaludoRecibido(saludo);
    }

    // (Puedes borrar el método antiguo de "saludoDefault" si quieres para limpiar, o dejarlo)
}