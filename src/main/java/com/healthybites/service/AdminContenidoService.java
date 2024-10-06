package com.healthybites.service;

import com.healthybites.dto.ContenidoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminContenidoService {
    List<ContenidoDTO> getAll();
    Page<ContenidoDTO> paginate(Pageable pageable);
    ContenidoDTO findById(Integer id);
    ContenidoDTO create(ContenidoDTO ContenidoDTO);
    ContenidoDTO update(Integer id, ContenidoDTO updateContenidoDTO);
    void delete(Integer id);
}
