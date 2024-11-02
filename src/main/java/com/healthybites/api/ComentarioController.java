package com.healthybites.api;

import com.healthybites.dto.ComentarioCreateDTO;
import com.healthybites.dto.ComentarioDTO;
import com.healthybites.service.ComentarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comentario")
@PreAuthorize("hasRole('CLIENTE')")
public class ComentarioController {

    private final ComentarioService comentarioService;

    @GetMapping("/publicacion/{id}")
    public ResponseEntity<List<ComentarioDTO>> getAll(@PathVariable Integer id) {
        List<ComentarioDTO> comentarios = comentarioService.getAll(id);
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ComentarioDTO> create(@RequestBody ComentarioCreateDTO comentarioCreateDTO) {
        ComentarioDTO comentarioDTO = comentarioService.create(comentarioCreateDTO);
        return new ResponseEntity<>(comentarioDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{comentarioId}/publicacion/{publicacionId}")
    public ResponseEntity<ComentarioDTO> getById(@PathVariable Integer publicacionId, @PathVariable Integer comentarioId) {
        ComentarioDTO comentario = comentarioService.findByIdAndPublicacionId(comentarioId, publicacionId);
        return new ResponseEntity<>(comentario, HttpStatus.OK);
    }

    @PutMapping("/{comentarioId}/publicacion/{publicacionId}")
    public ResponseEntity<ComentarioDTO> update(@PathVariable Integer publicacionId, @PathVariable Integer comentarioId, @RequestBody ComentarioCreateDTO updatedComentarioDTO) {
        ComentarioDTO comentario = comentarioService.update(comentarioId, publicacionId, updatedComentarioDTO);
        return new ResponseEntity<>(comentario, HttpStatus.OK);
    }

    @DeleteMapping("/{comentarioId}/publicacion/{publicacionId}")
    public ResponseEntity<Void> delete(@PathVariable Integer publicacionId, @PathVariable Integer comentarioId) {
        comentarioService.delete(comentarioId, publicacionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
