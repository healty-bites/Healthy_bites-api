package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class UnirsePK {
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_unirse_cliente"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_unirse_grupo"))
    private Grupo grupo;
}
