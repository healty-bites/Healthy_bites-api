
package com.healthybites.service;

import com.healthybites.dto.LoginRequest;
import com.healthybites.model.entity.Cliente;

public interface ClienteService {
    Cliente registerCliente(Cliente cliente);
    Cliente loginCliente(LoginRequest loginRequest);  // Método de login

}