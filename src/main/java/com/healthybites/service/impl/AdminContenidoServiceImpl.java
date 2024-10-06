package com.healthybites.service.impl;

import com.healthybites.dto.ContenidoDTO;
import com.healthybites.exception.BadRequestException;
import com.healthybites.exception.ResourceNotFoundException;
import com.healthybites.mapper.ContenidoMapper;
import com.healthybites.model.entity.Contenido;
import com.healthybites.model.entity.Nutricionista;
import com.healthybites.repository.ContenidoRepository;
import com.healthybites.repository.NutricionistaRepository;
import com.healthybites.service.AdminContenidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminContenidoServiceImpl implements AdminContenidoService {

    private final ContenidoRepository contenidoRepository;
    private final NutricionistaRepository nutricionistaRepository;
    private final ContenidoMapper contenidoMapper;

    @Transactional(readOnly = true)
    @Override
    public List<ContenidoDTO> getAll() {
        List<Contenido> contenidos = contenidoRepository.findAll();
        return contenidos.stream()
                .map(contenidoMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ContenidoDTO> paginate(Pageable pageable) {
        Page<Contenido> contenidos = contenidoRepository.findAll(pageable);
        return contenidos.map(contenidoMapper::toDTO);
    }

    @Transactional(readOnly = true)
    @Override
    public ContenidoDTO findById(Integer id) {
        Contenido contenido = contenidoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El contenido con"+id+" no existe."));
        return contenidoMapper.toDTO(contenido);
    }

    @Transactional
    @Override
    public ContenidoDTO create(ContenidoDTO contenidoDTO) {
        Nutricionista nutricionista = nutricionistaRepository.findById(contenidoDTO.getNutricionista().getId())
                .orElseThrow(() -> new BadRequestException("Nutricionista no encontrado por ID: " + contenidoDTO.getNutricionista()));

        Contenido contenido = contenidoMapper.toEntity(contenidoDTO);
        contenido.setNutricionista(nutricionista);
        contenido = contenidoRepository.save(contenido);
        return contenidoMapper.toDTO(contenido);


    }


    @Transactional
    @Override
    public ContenidoDTO update(Integer id, ContenidoDTO updateContenidoDTO) {
        Contenido contenidoFromDB = contenidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID de contenido no encontrado: " + id));

        contenidoRepository.findByTitulo(updateContenidoDTO.getTitulo())
                .filter(existingContenido -> !existingContenido.getId().equals(id))
                .ifPresent(existingContenido -> {
                    throw new BadRequestException("Ya existe contenido con el mismp título.");
                });

        Nutricionista nutricionista = nutricionistaRepository.findById(updateContenidoDTO.getNutricionista().getId())
                .orElseThrow(() -> new ResourceNotFoundException("ID de nutricionista no encontrado: " + updateContenidoDTO.getNutricionista()));

        contenidoFromDB.setTitulo(updateContenidoDTO.getTitulo());
        contenidoFromDB.setDescripcion(updateContenidoDTO.getDescripcion());
        contenidoFromDB.setTipoContenido(updateContenidoDTO.getTipoContenido());
        contenidoFromDB.setCategoriaContenido(updateContenidoDTO.getCategoriaContenido());
        contenidoFromDB.setEsGratis(updateContenidoDTO.isEsGratis());
        contenidoFromDB.setNutricionista(nutricionista);

        contenidoFromDB = contenidoRepository.save(contenidoFromDB);
        return contenidoMapper.toDTO(contenidoFromDB);

    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Contenido contenido = contenidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID de contenido no encontrado: " + id));
        contenidoRepository.delete(contenido);
    }
}