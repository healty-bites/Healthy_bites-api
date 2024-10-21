package com.healthybites.dto.ClienteDTO;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {
    private Integer id;

    private String clienteNombre;

    private String sexo;

    private String correo;

    private String edad;

    private String altura;

    private String peso;

    private ClienteMetaDTO meta;

    private ClienteSuscripcionDTO suscripcion;

    private ClienteRachaDTO racha;

    private List<RecompensaDTO> recompensas;

    private List<ClienteHabitoDTO> habitos;

    private List<ContenidoDTO> contenidos;

    private List<PlanAlimenticioDTO> planesAlimenticios;

}
