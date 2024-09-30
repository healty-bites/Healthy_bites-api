package com.healthybites.service.impl;

import com.healthybites.model.entity.Cliente;
import com.healthybites.model.entity.Meta;
import com.healthybites.repository.ClienteRepository;
import com.healthybites.repository.MetaRepository;
import com.healthybites.service.AdminMetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminMetaServiceImpl implements AdminMetaService{

    private final MetaRepository metaRepository;
    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<Meta> getAll() {
        return metaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Meta> paginate(Pageable pageable) {
        return metaRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Meta findById(Integer id) {
        return metaRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Meta no encontrada"));
    }

    @Transactional
    public Meta create(Meta meta) {
        Cliente cliente = clienteRepository.findById(meta.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + meta.getCliente().getId()));

        meta.setCliente(cliente);

        return metaRepository.save(meta);
    }

    @Transactional
    public Meta update(Integer id, Meta updateMeta) {
        Meta metaFromDB = findById(id);
        Cliente cliente = clienteRepository.findById(updateMeta.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + updateMeta.getCliente().getId()));

        metaFromDB.setNombre(updateMeta.getNombre());
        metaFromDB.setDescripcion(updateMeta.getDescripcion());
        metaFromDB.setPesoObjetivo(updateMeta.getPesoObjetivo());
        metaFromDB.setCliente(cliente);
        return metaRepository.save(metaFromDB);
    }

    @Transactional
    public void delete(Integer id) {
        Meta meta = findById(id);
        metaRepository.delete(meta);
    }
}