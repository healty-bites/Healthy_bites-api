package com.healthybites.dto;

import lombok.Data;

@Data
public class RecompensaDetailsDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private int diasRequeridos;
    private String nutricionistaNombre;
}
