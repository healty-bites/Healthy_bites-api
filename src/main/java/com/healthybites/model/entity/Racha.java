package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "racha")
public class Racha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dias_consecutivos", nullable = false)
    private int diasConsecutivos;

    @Column(name = "fecha_registro_actual", nullable = false)
    private LocalDateTime fechaRegistro;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_racha_cliente"))
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_recompensa", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_racha_recompensa"))
    private Recompensa recompensa;

}
