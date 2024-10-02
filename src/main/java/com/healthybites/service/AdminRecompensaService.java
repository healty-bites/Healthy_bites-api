package com.healthybites.service;

import com.healthybites.dto.RecompensaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminRecompensaService {
    List<RecompensaDTO> getAll();
    Page<RecompensaDTO> paginate(Pageable pageable);
    RecompensaDTO findById(Integer id);
    RecompensaDTO create( RecompensaDTO RecompensaDTO);
    RecompensaDTO update(Integer id, RecompensaDTO updateRecompensaDTO);
    void delete(Integer id);
}
