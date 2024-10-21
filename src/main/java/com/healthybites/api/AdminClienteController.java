package com.healthybites.api;

import com.healthybites.model.entity.Cliente;
import com.healthybites.service.AdminClienteService;
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
    public ResponseEntity<List<Cliente>> getAllCliente() {
        List<Cliente> clientes = adminClienteService.getAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Integer id) {
        Cliente cliente = adminClienteService.findById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente newCliente = adminClienteService.create(cliente);
        return new ResponseEntity<>(newCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        Cliente updateCliente = adminClienteService.update(id, cliente);
        return new ResponseEntity<>(updateCliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") Integer id) {
        adminClienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}