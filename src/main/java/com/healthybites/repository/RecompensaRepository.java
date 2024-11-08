package com.healthybites.repository;

import com.healthybites.model.entity.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecompensaRepository extends JpaRepository<Recompensa, Integer> {
    List<Recompensa> findByNutricionistaId(Integer nutricionistaId);
    Optional<Recompensa> findByIdAndNutricionistaId(Integer recompensaId, Integer nutricionistaId);
}
