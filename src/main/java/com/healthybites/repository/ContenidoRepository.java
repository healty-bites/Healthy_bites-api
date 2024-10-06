package com.healthybites.repository;

import com.healthybites.model.entity.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {
    List<Contenido> findByNutricionistaId(Integer nutricionistaId);

    Optional<Contenido> findByTitulo(String titulo);
}