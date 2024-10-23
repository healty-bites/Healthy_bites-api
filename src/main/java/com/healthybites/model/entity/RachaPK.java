package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class RachaPK {

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_racha_cliente"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_recompensa", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_racha_recompensa"))
    private Recompensa recompensa;
}
