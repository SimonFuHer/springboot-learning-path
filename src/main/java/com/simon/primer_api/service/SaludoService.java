package com.simon.primer_api.service;

import com.simon.primer_api.model.Saludo;
import com.simon.primer_api.repository.SaludoRepository; // 🆕 Importamos el repositorio
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaludoService {

    // 1. Ya no usamos una lista en memoria (Adiós ArrayList 👋)
    // private final List<Saludo> historial = new ArrayList<>();

    // 2. Ahora inyectamos el REPOSITORIO
    private final SaludoRepository saludoRepository;

    public SaludoService(SaludoRepository saludoRepository) {
        this.saludoRepository = saludoRepository;
    }

    // --- MÉTODOS ---

    public Saludo generarSaludo(String nombre) {
        return new Saludo("Hola " + nombre, "Simón", "Saludo generado al vuelo");
    }

    public Saludo procesarSaludoRecibido(Saludo saludo) {
        // 3. GUARDAR EN BASE DE DATOS REAL 💾
        // El método .save() hace el INSERT en SQL automáticamente
        return saludoRepository.save(saludo);
    }

    public List<Saludo> obtenerTodosLosSaludos() {
        // 4. LEER DE BASE DE DATOS REAL 📖
        // El método .findAll() hace el SELECT * FROM automáticamente
        return saludoRepository.findAll();
    }
}