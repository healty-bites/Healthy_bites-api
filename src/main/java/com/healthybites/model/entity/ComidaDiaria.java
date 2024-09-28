package com.healthybites.model.entity;

import com.healthybites.model.enums.CategoriaComida;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comida_diaria")
public class ComidaDiaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_comida", nullable = false)
    private String nombreComida;

    @Column(name = "calorias", nullable = false)
    private int calorias;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", nullable = false)
    private CategoriaComida categoria;

    @ManyToOne
    @JoinColumn(name = "id_planalimenticio", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_comidadiaria_planalimenticio"))
    private PlanAlimenticio planAlimenticio;
}
