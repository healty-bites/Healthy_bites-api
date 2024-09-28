package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "altura", nullable = false)
    private double altura;

    @Column(name = "peso", nullable = false)
    private double peso;

    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_cliente_grupo"))
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "id_meta", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_cliente_meta"))
    private Meta meta;

    @ManyToOne
    @JoinColumn(name = "id_suscripcion", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_cliente_suscripcion"))
    private Suscripcion suscripcion;

    @ManyToOne
    @JoinColumn(name = "id_racha", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_cliente_racha"))
    private Racha racha;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_cliente_usuario"))
    private Usuario usuario;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Recompensa> recompensas;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Habito> habitos;

}
