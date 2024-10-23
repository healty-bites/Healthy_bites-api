package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "acceso_contenido")
@IdClass(AccesoContenidoPK.class)
public class AccesoContenido {
    @Id
    private Integer cliente;

    @Id
    private Integer contenido;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;
}
