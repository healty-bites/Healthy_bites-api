package com.healthybites.model.entity;

import com.healthybites.model.enums.EstadoPago;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pago", nullable = false)
    private EstadoPago estadoPago;

    @ManyToOne
    @JoinColumn(name = "id_suscripcion", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_pago_suscripcion"))
    private Suscripcion suscripcion;
}
