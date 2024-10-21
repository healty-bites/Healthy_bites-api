package com.healthybites.api;

import com.healthybites.dto.ClienteDTO;
import com.healthybites.model.entity.Cliente;
import com.healthybites.service.AdminClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/cliente")
public class AdminClienteController {

    private final AdminClienteService adminClienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllCliente() {
        List<ClienteDTO> clientes = adminClienteService.getAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO newCliente = adminClienteService.create(clienteDTO);
        return new ResponseEntity<>(newCliente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Integer id) {
        ClienteDTO cliente = adminClienteService.findById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Integer id, @Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO updatedCliente = adminClienteService.update(id, clienteDTO);
        return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        adminClienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}