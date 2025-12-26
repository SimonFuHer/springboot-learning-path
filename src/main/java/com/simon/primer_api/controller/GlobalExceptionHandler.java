package com.simon.primer_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// 1. Esta etiqueta le dice a Spring: "Oye, si hay un error en CUALQUIER controlador, avísame a mí"
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 2. Este método salta cuando fallan las validaciones (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> manejarErroresDeValidacion(MethodArgumentNotValidException ex) {

        // Creamos un mapa (diccionario) para guardar los errores: campo -> mensaje
        Map<String, String> errores = new HashMap<>();

        // Recorremos todos los errores que ha detectado Spring
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String campo = ((FieldError) error).getField(); // Ejemplo: "titulo"
            String mensaje = error.getDefaultMessage();     // Ejemplo: "El título es obligatorio"
            errores.put(campo, mensaje);
        });

        // Devolvemos el mapa con un error 400 (Bad Request)
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
}