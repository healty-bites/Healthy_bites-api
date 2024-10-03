package com.healthybites.service.impl;

import com.healthybites.dto.LoginRequest;
import com.healthybites.model.entity.Cliente;
import com.healthybites.repository.ClienteRepository;
import com.healthybites.service.ClienteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@RequiredArgsConstructor
@Service

public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Transactional
    @Override
    public Cliente registerCliente(Cliente cliente) {
        if(clienteRepository.existsByCorreo(cliente.getCorreo())){
            throw new RuntimeException("El correo ya está registrado");
        }
        cliente.setCreatedAt(LocalDateTime.now());
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente loginCliente(LoginRequest loginRequest) {
        Optional<Cliente> clienteOpt = clienteRepository.findByCorreo(loginRequest.getCorreo());

        // Verificar si el cliente existe y si la contraseña es correcta
        if (clienteOpt.isPresent() && clienteOpt.get().getContrasena().equals(loginRequest.getContrasena())) {
            return clienteOpt.get();  // Retorna el cliente si las credenciales son correctas
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }

    }
}

