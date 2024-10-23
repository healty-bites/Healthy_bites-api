package com.healthybites.service;

import com.healthybites.dto.ComidaDiariaDTO;
import com.healthybites.dto.PlanAlimenticioCreateDTO;
import com.healthybites.dto.PlanAlimenticioDTO;

import java.util.List;

public interface PlanAlimenticioService {
    List<PlanAlimenticioDTO> getAll();
    List<ComidaDiariaDTO> getAllComidasByPlanId(Integer planId);

    PlanAlimenticioDTO findById(Integer id);

    PlanAlimenticioDTO create(PlanAlimenticioCreateDTO planAlimenticioCreateDTO);
    ComidaDiariaDTO addComidaToPlan(Integer planId, ComidaDiariaDTO comidaDiariaDTO);

    ComidaDiariaDTO getComidaById(Integer planId, Integer comidaId);

    PlanAlimenticioDTO update(Integer id, PlanAlimenticioCreateDTO updatedPlanAlimenticioDTO);
    ComidaDiariaDTO updateComida(Integer planId, Integer comidaId, ComidaDiariaDTO comidaDiariaUpdateDTO); // Actualizar una comida específica

    void delete(Integer id);
    void deleteComida(Integer planId, Integer comidaId);
}
