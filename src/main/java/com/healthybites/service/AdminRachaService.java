package com.healthybites.service;

import com.healthybites.dto.RachaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminRachaService {
    List<RachaDTO> getAll();
    Page<RachaDTO> paginate(Pageable pageable);
    RachaDTO findById(Integer id);
    RachaDTO create(RachaDTO RecompensaDTO);
    RachaDTO update(Integer id, RachaDTO updateRachaDTO);
    void delete(Integer id);
}
