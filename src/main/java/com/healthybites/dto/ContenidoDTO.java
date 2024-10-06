package com.healthybites.dto;

import com.healthybites.model.enums.CategoriaContenido;
import com.healthybites.model.enums.TipoContenido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContenidoDTO {
    private Integer id;

    @NotBlank(message= "Debes ingresar un título.")
    @Size(max = 60, message = "El título no debe superar los 60 caracteres.")
    private String titulo;

    @NotBlank(message= "Debes ingresar una descripción.")
    @Size(max = 4000, message = "La descripción ha superado los 4000 caracteres.")
    private String descripcion;

    @NotNull(message= "Debes ingresar un tipo de contenido.")
    private TipoContenido tipoContenido;

    @NotNull(message= "Debes indicar que categoría de contenido estás ingresando.")
    private CategoriaContenido categoriaContenido;

    private boolean esGratis;

    @NotNull(message = "El nutricionista es obligatorio")
    private NutricionistaDTO nutricionista;
}