package com.simon.primer_api.model;

public class Saludo {
    private String titulo;
    private String autor;
    private String contenido;

    // 1. Constructor: Para crear el objeto fácilmente
    public Saludo(String titulo, String autor, String contenido) {
        this.titulo = titulo;
        this.autor = autor;
        this.contenido = contenido;
    }

    // 2. GETTERS: ¡IMPORTANTÍSIMO! ⚠️
    // Sin estos métodos, Spring Boot NO podrá leer los datos para convertirlos a JSON.
    // (Spring usa los Getters para "sacar" la información privada).

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