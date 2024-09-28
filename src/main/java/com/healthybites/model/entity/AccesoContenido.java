package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "acceso_contenido")
public class AccesoContenido {
    @Id
    private Integer cliente;

    @Id
    private Integer contenido;
}
