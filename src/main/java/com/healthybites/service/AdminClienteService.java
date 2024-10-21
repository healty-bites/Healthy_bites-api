package com.healthybites.service;

import com.healthybites.dto.ClienteDTO;
import com.healthybites.model.entity.Cliente;

import java.util.List;

public interface AdminClienteService {
    List<ClienteDTO> getAll();
    ClienteDTO findById(Integer id);
    ClienteDTO create(ClienteDTO clienteDTO);
    ClienteDTO update(Integer id, ClienteDTO updatedClienteDTO);
    void delete(Integer id);
}
