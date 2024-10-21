package com.healthybites.service;

import com.healthybites.dto.ContenidoCreateUpdateDTO;
import com.healthybites.dto.ContenidoDetailsDTO;

import java.util.List;

public interface ContenidoService {
    List<ContenidoDetailsDTO> getAll();
    ContenidoDetailsDTO findById(Integer id);
    ContenidoDetailsDTO create(ContenidoCreateUpdateDTO contenidoCreateUpdateDTO);
    ContenidoDetailsDTO update(Integer id, ContenidoCreateUpdateDTO updateContenidoDTO);
    void delete(Integer id);
}
