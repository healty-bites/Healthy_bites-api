package com.healthybites.model.entity;

import com.healthybites.model.enums.TipoSuscripcion;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "suscripcion")
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_suscripcion", nullable = false)
    private TipoSuscripcion tipoSuscripcion;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_suscripcion_cliente"))
    private Cliente cliente;
}
