package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "racha")
public class Racha {

    @Id
    private Integer cliente;

    @Id
    private Integer Recompensa;

    @Column(name = "dias_consecutivos", nullable = false)
    private int diasConsecutivos;

    @Column(name = "fecha_registro_actual", nullable = false)
    private LocalDateTime fechaRegistroActual;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}
