package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "recompensa")
public class Recompensa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "dias_requeridos", nullable = false)
    private int diasRequeridos;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;

    @OneToOne
    @JoinColumn(name = "id_racha", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_recompensa_racha"))
    private Racha racha;

    @ManyToOne
    @JoinColumn(name = "id_nutricionista", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_recompensa_nutricionista"))
    private Nutricionista nutricionista;


}
