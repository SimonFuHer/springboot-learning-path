package com.simon.primer_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank; // 🆕 Para que no esté vacío
import jakarta.validation.constraints.Size;     // 🆕 Para controlar el tamaño

@Entity
public class Saludo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🆕 REGLAS PARA EL TÍTULO
    @NotBlank(message = "El título es obligatorio")
    @Size(min = 3, message = "El título debe tener al menos 3 letras")
    private String titulo;

    // 🆕 REGLAS PARA EL AUTOR
    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    // 🆕 REGLAS PARA EL CONTENIDO
    @NotBlank(message = "El contenido es obligatorio")
    private String contenido;

    // --- CONSTRUCTOR VACÍO, CONSTRUCTOR NORMAL, GETTERS Y SETTERS ---
    // (Déjalos tal cual los tenías, no cambian nada)

    public Saludo() {}

    public Saludo(String titulo, String autor, String contenido) {
        this.titulo = titulo;
        this.autor = autor;
        this.contenido = contenido;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getContenido() { return contenido; }
}