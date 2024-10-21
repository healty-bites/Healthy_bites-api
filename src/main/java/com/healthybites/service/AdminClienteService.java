package com.healthybites.service;

import com.healthybites.model.entity.Cliente;

import java.util.List;

public interface AdminClienteService {
    List<Cliente> getAll();
    Cliente findById(Integer id);
    Cliente create(Cliente cliente);
    Cliente update(Integer id, Cliente updateCliente);
    void delete(Integer id);

}
