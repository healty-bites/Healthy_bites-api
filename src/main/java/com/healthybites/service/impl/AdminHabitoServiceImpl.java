package com.healthybites.service.impl;

import com.healthybites.model.entity.Habito;
import com.healthybites.repository.HabitoRepository;
import com.healthybites.service.AdminHabitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminHabitoServiceImpl implements AdminHabitoService {

    private final HabitoRepository habitoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Habito> getAll() {
        return habitoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Habito> paginate(Pageable pageable) {
        return habitoRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Habito findById(Integer id) {
        return habitoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Habito no encontrado"));
    }

    @Transactional
    @Override
    public Habito create(Habito habito) {
        return habitoRepository.save(habito);
    }

    @Transactional
    @Override
    public Habito update(Integer id, Habito updateHabito) {
        Habito habitoFromDB = findById(id);
        habitoFromDB.setNombre(updateHabito.getNombre());
        habitoFromDB.setHidratacion(updateHabito.getHidratacion());
        habitoFromDB.setAlimentacion(updateHabito.getAlimentacion());
        habitoFromDB.setEjercicio(updateHabito.getEjercicio());
        habitoFromDB.setCalidadDeSueno(updateHabito.getCalidadDeSueno());
        return habitoRepository.save(habitoFromDB);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Habito habito = findById(id);
        habitoRepository.delete(habito);
    }
}