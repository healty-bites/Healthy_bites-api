package com.healthybites.dto;

import com.healthybites.model.enums.CategoriaComida;
import lombok.Data;

@Data
public class ComidaDiariaDTO {
    private Integer id;

    private String nombreComida;

    private int calorias;

    private CategoriaComida categoria;
}