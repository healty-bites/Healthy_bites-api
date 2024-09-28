package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String correo;

    private String contrasena;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cliente cliente;

    // Relación uno a uno con Author (si el usuario es autor)
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Nutricionista nutricionista;

    // Relación muchos a uno con Role (para determinar si es cliente o autor)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_usuario_rol"))
    private Rol rol;
}
