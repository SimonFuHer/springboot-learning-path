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

    // MÉTODOS PARA BORRAR
    public void borrarSaludo(Long id) {
        // El repositorio ya tiene un método mágico para esto
        saludoRepository.deleteById(id);
    }

    // MÉTODOS PARA ACTUALIZAR (PUT)
    public Saludo actualizarSaludo(Long id, Saludo saludoConNuevosDatos) {
        // 1. Buscamos el saludo antiguo
        // .orElse(null) significa: "Si no lo encuentras, devuélveme nulo"
        Saludo saludoAntiguo = saludoRepository.findById(id).orElse(null);

        if (saludoAntiguo != null) {
            // 2. Si existe, actualizamos sus datos con los nuevos
            saludoAntiguo.setTitulo(saludoConNuevosDatos.getTitulo());
            saludoAntiguo.setAutor(saludoConNuevosDatos.getAutor());
            saludoAntiguo.setContenido(saludoConNuevosDatos.getContenido());

            // 3. Guardamos los cambios en la base de datos
            return saludoRepository.save(saludoAntiguo);
        } else {
            return null; // Si no existe, no hacemos nada (por ahora)
        }
    }
}