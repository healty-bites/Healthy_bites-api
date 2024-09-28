package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class AccesoContenidoPK {

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_accesocontenido_cliente"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_contenido", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_accesocontenido_contenido"))
    private Contenido contenido;
}
