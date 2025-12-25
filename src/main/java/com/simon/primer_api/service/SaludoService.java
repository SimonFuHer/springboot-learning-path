package com.simon.primer_api.service;

import com.simon.primer_api.model.Saludo;
import org.springframework.stereotype.Service;

import java.util.ArrayList; // 🆕 Importar lista
import java.util.List;      // 🆕 Importar interfaz List

@Service
public class SaludoService {

    // 🆕 ESTO ES TU BASE DE DATOS DE MENTIRA
    // Una lista que vive en la memoria RAM mientras la app está encendida.
    private final List<Saludo> historial = new ArrayList<>();

    public Saludo generarSaludo(String nombre) {
        return new Saludo("Hola " + nombre, "Simón", "Saludo generado al vuelo");
    }

    // Modificamos este método para GUARDAR en la lista
    public Saludo procesarSaludoRecibido(Saludo saludo) {

        // 🆕 1. Apuntamos el saludo en nuestra lista
        historial.add(saludo);

        // 🆕 2. Devolvemos confirmación
        return new Saludo(
                "Recibido y Guardado en Memoria",
                saludo.getAutor(),
                "Tu saludo es el número " + historial.size() + " en la lista temporal."
        );
    }

    // 🆕 Nuevo método para LEER la lista completa
    public List<Saludo> obtenerTodosLosSaludos() {
        return historial;
    }
}