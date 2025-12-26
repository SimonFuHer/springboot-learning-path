package com.simon.primer_api.repository;

import com.simon.primer_api.model.Saludo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaludoRepository extends JpaRepository<Saludo, Long> {
    // ¡NO ESCRIBAS NADA AQUÍ!
    // Al extender de JpaRepository, Spring ya te regala métodos como:
    // .save()   -> Guardar
    // .findAll() -> Buscar todos
    // .findById() -> Buscar uno
}