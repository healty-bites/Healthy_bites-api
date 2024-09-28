package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "seguimiento")
public class Seguimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "peso_del_dia", nullable = false)
    private double pesoDelDia;

    @Column(name = "obsevaciones", nullable = false)
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_meta", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_seguimiento_meta"))
    private Meta meta;
}
