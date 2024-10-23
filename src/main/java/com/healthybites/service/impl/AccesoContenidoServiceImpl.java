package com.healthybites.service.impl;

import com.healthybites.dto.ContenidoDetailsDTO;
import com.healthybites.mapper.ContenidoMapper;
import com.healthybites.model.entity.AccesoContenido;
import com.healthybites.model.entity.Cliente;
import com.healthybites.model.entity.Contenido;
import com.healthybites.repository.AccesoContenidoRepository;
import com.healthybites.repository.ClienteRepository;
import com.healthybites.repository.ContenidoRepository;
import com.healthybites.service.AccesoContenidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.ref.PhantomReference;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccesoContenidoServiceImpl implements AccesoContenidoService {

    private final AccesoContenidoRepository accesoContenidoRepository;
    private final ContenidoRepository contenidoRepository;
    private final ContenidoMapper contenidoMapper;
    private final ClienteRepository clienteRepository;

    @Override
    public ContenidoDetailsDTO addContentToClient(Integer clientId, Integer contentId) {
        LocalDateTime fecha = LocalDateTime.now();
        accesoContenidoRepository.addContenidoToCliente(clientId, contentId, fecha);

        Contenido contenido = contenidoRepository.findById(contentId)
                .orElseThrow(() -> new RuntimeException("Contenido no encontrado"));

        return contenidoMapper.toDTO(contenido);
    }

    @Override
    public void removeContentFromClient(Integer clientId, Integer contentId) {
        accesoContenidoRepository.deleteByClienteAndContenido(clientId, contentId);
    }

    @Override
    public List<ContenidoDetailsDTO> getAllContentByClient(Integer clientId) {
        Cliente cliente = clienteRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        List<Contenido> contenidos = accesoContenidoRepository.findAccesoContenidoByCliente(cliente);

        return contenidos.stream()
                .map(contenidoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
