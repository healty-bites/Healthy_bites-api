package com.healthybites.repository;

import com.healthybites.model.entity.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuscripcionRepository extends JpaRepository<Suscripcion, Integer> {
    Optional<Suscripcion> findByTipoSuscripcion(String tipoSuscripcion);
}
