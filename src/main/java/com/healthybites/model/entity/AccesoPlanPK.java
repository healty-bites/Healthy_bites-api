package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class AccesoPlanPK {

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_accesoplan_cliente"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_plan_alimenticio", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_accesoplan_alimenticio"))
    private PlanAlimenticio planAlimenticio;
}
