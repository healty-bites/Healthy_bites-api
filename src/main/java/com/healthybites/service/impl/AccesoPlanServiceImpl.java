package com.healthybites.service.impl;

import com.healthybites.dto.PlanAlimenticioDTO;
import com.healthybites.mapper.PlanAlimenticioMapper;
import com.healthybites.model.entity.AccesoPlan;
import com.healthybites.model.entity.Cliente;
import com.healthybites.model.entity.PlanAlimenticio;
import com.healthybites.repository.AccesoPlanRepository;
import com.healthybites.repository.ClienteRepository;
import com.healthybites.repository.PlanAlimenticioRepository;
import com.healthybites.service.AccesoPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.ref.PhantomReference;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccesoPlanServiceImpl implements AccesoPlanService {

    private final AccesoPlanRepository accesoPlanRepository;
    private final PlanAlimenticioRepository planAlimenticioRepository;
    private final ClienteRepository clienteRepository;
    private final PlanAlimenticioMapper planAlimenticioMapper;

    @Override
    public PlanAlimenticioDTO addPlanToClient(Integer clientId, Integer planId) {
        LocalDateTime fecha = LocalDateTime.now();
        accesoPlanRepository.addPlanToCliente(clientId, planId, fecha);

        PlanAlimenticio plan = planAlimenticioRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        return planAlimenticioMapper.toDTO(plan);
    }

    @Override
    public void removePlanFromClient(Integer clientId, Integer planId) {
        // Verifica si el plan está asociado al cliente
        boolean planPertenece = accesoPlanRepository.existsByClienteIdAndPlanId(clientId, planId);

        if (!planPertenece) {
            throw new IllegalArgumentException("El plan no pertenece al cliente");
        }


        // Si el plan pertenece al cliente, entonces se procede a eliminar
        accesoPlanRepository.deleteByClienteAndPlan(clientId, planId);
    }


    @Override
    public List<PlanAlimenticioDTO> getAllPlansByClient(Integer clientId) {
        Cliente cliente = clienteRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        List<PlanAlimenticio> planes = accesoPlanRepository.findAccesoPlanByCliente(cliente);

        return planes.stream()
                .map(planAlimenticioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
