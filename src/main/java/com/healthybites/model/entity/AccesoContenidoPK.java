package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class AccesoContenidoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_accesocontenido_cliente"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "contenido_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_accesocontenido_contenido"))
    private Contenido contenido;
}
