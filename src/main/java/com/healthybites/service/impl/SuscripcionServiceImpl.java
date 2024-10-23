package com.healthybites.service.impl;

import com.healthybites.dto.SuscripcionCreateUpdateDTO;
import com.healthybites.dto.SuscripcionDetailsDTO;
import com.healthybites.exception.BadRequestException;
import com.healthybites.exception.ResourceNotFoundException;
import com.healthybites.mapper.SuscripcionMapper;
import com.healthybites.model.entity.Cliente;
import com.healthybites.model.entity.Suscripcion;
import com.healthybites.model.enums.TipoSuscripcion;
import com.healthybites.repository.ClienteRepository;
import com.healthybites.repository.SuscripcionRepository;
import com.healthybites.service.SuscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SuscripcionServiceImpl implements SuscripcionService {

    private final SuscripcionRepository suscripcionRepository;
    private final ClienteRepository clienteRepository;
    private final SuscripcionMapper suscripcionMapper;

    @Transactional(readOnly = true)
    @Override
    public List<SuscripcionDetailsDTO> getAll() {
        List<Suscripcion> suscripciones = suscripcionRepository.findAll();
        return suscripciones.stream()
                .map(suscripcionMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public SuscripcionDetailsDTO findById(Integer id) {
        Suscripcion suscripcion = suscripcionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Suscripcion con id " + id + " no encontrado"));
        return suscripcionMapper.toDTO(suscripcion);
    }

    @Override
    public SuscripcionDetailsDTO create(SuscripcionCreateUpdateDTO suscripcionCreateUpdateDTO) {
        Suscripcion suscripcion = suscripcionMapper.toEntity(suscripcionCreateUpdateDTO);

        switch (suscripcion.getTipoSuscripcion()) {
            case BASICO -> {
                suscripcion.setPrecio(0.00);
            }
            case PREMIUM -> {
                suscripcion.setPrecio(5.99);
            }
            case VIP -> {
                suscripcion.setPrecio(9.99);
            }
        }

        return suscripcionMapper.toDTO(suscripcionRepository.save(suscripcion));
    }

    @Override
    public SuscripcionDetailsDTO update(Integer id, SuscripcionCreateUpdateDTO updateSuscripcionDTO) {
        Suscripcion suscripcionFromDb = suscripcionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Suscripcion con id " + id + " no encontrado"));


        suscripcionFromDb.setTipoSuscripcion(updateSuscripcionDTO.getTipoSuscripcion());

        switch (updateSuscripcionDTO.getTipoSuscripcion()) {
            case BASICO -> {
                suscripcionFromDb.setPrecio(0.00);
            }
            case PREMIUM -> {
                suscripcionFromDb.setPrecio(5.99);
            }
            case VIP -> {
                suscripcionFromDb.setPrecio(9.99);
            }
        }

        return suscripcionMapper.toDTO(suscripcionRepository.save(suscripcionFromDb));
    }

    @Override
    public void delete(Integer id) {
        Suscripcion suscripcion = suscripcionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Suscripcion con id " + id + " no encontrado"));
        suscripcionRepository.delete(suscripcion);
    }
}
