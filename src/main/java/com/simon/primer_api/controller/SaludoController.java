package com.simon.primer_api.controller;

import com.simon.primer_api.model.Saludo; // <--- Importante: Importar tu nueva clase
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping("/saludo")
    public Saludo holaMundo() { // <--- Fíjate: Ya no devuelve 'String', ahora devuelve 'Saludo'

        // Creamos el objeto con datos reales
        return new Saludo("Hola JSON", "Simón", "¡Mira mamá, mi API devuelve objetos!");
    }
}