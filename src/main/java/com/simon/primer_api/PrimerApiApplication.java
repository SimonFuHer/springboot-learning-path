package com.simon.primer_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // <--- 1. Anotación nueva: "Esta clase ahora escucha peticiones web"
public class PrimerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimerApiApplication.class, args);
	}

	// 2. Método nuevo: Cuando alguien entre a la raíz, responde esto
	@GetMapping("/saludo")
	public String holaMundo() {
		return "¡Hola Simón! Tu primera API con Spring Boot está viva 🚀";
	}
}