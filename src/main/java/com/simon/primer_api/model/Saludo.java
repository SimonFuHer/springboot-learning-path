package com.simon.primer_api.model;

import jakarta.persistence.Entity; // 🆕 Importante
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 1. ¡Esto convierte la clase en una Tabla!
public class Saludo {

    @Id // 2. Esta es la llave primaria (el DNI del dato)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se autoincrementa solo (1, 2, 3...)
    private Long id;

    private String titulo;
    private String autor;
    private String contenido;

    // 3. ⚠️ CONSTRUCTOR VACÍO (Obligatorio para JPA)
    public Saludo() {
    }

    // Tu constructor normal (lo mantenemos para usarlo nosotros)
    public Saludo(String titulo, String autor, String contenido) {
        this.titulo = titulo;
        this.autor = autor;
        this.contenido = contenido;
    }

    // GETTERS (Los necesitamos todos, incluido el ID)
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getContenido() {
        return contenido;
    }
}