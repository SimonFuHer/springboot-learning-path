package com.simon.primer_api.controller;

import com.simon.primer_api.model.Saludo; // <--- Importante: Importar tu nueva clase
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    // Fíjate en el cambio: añadimos /{nombre} entre llaves
    @GetMapping("/saludo/{nombre}")
    public Saludo holaMundo(@PathVariable String nombre) {
        // @PathVariable conecta la URL con la variable 'nombre' de Java

        return new Saludo(
                "Hola " + nombre,
                "Simón",
                "¡Enhorabuena " + nombre + ", tu API ya responde dinámicamente!"
        );
    }
}