package com.healthybites.api;

import com.healthybites.dto.ContenidoDTO;
import com.healthybites.model.entity.Contenido;
import com.healthybites.service.AdminContenidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/contenido")
public class AdminContenidoController {

    private final AdminContenidoService adminContenidoService;

    @GetMapping
    public ResponseEntity<List<ContenidoDTO>> getAllContenido() {
        List<ContenidoDTO> contenidos = adminContenidoService.getAll();
        return new ResponseEntity<>(contenidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContenidoDTO> getContenidoById(@PathVariable("id") Integer id) {
        ContenidoDTO contenido = adminContenidoService.findById(id);
        return new ResponseEntity<>(contenido, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContenidoDTO> createContenido(@Valid @RequestBody ContenidoDTO contenidoDTO) {
        ContenidoDTO newContenido = adminContenidoService.create(contenidoDTO);
        return new ResponseEntity<>(newContenido, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContenidoDTO> updateContenido(@PathVariable("id") Integer id,@Valid @RequestBody ContenidoDTO contenidoDTO) {
        ContenidoDTO updateContenido = adminContenidoService.update(id, contenidoDTO);
        return new ResponseEntity<>(updateContenido, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contenido> deleteContenido(@PathVariable("id") Integer id) {
        adminContenidoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
