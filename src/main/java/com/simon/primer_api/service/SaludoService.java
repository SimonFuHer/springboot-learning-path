package com.simon.primer_api.service;

import com.simon.primer_api.model.Saludo;
import org.springframework.stereotype.Service;

@Service // <--- 1. Esto convierte la clase en un "Bean" de Spring (Un componente oficial)
public class SaludoService {

    // Lógica para el saludo simple
    public Saludo generarSaludo(String nombre) {
        // Aquí podrías poner lógica compleja: validar si el nombre existe, ponerlo en mayúsculas, etc.
        return new Saludo(
                "Hola " + nombre,
                "Simón (desde Service)",
                "Este mensaje ha sido cocinado por el Chef 👨‍🍳"
        );
    }

    // Lógica para el POST (guardar)
    public Saludo procesarSaludoRecibido(Saludo saludo) {
        // Simulamos que modificamos los datos antes de guardarlos
        String tituloModificado = "Chef dice: " + saludo.getTitulo().toUpperCase();

        return new Saludo(
                tituloModificado,
                saludo.getAutor(),
                "El servicio ha procesado y validado este objeto JSON ✅"
        );
    }
}