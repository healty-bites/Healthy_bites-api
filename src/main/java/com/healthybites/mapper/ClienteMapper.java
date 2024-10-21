package com.healthybites.mapper;

import com.healthybites.dto.ClienteDTO.*;
import com.healthybites.model.entity.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    private final ModelMapper modelMapper;

    public ClienteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    // Convierte ClienteCreateDTO a Cliente
    public Cliente toClienteEntity(ClienteCreateDTO clienteCreateDTO) {
        return modelMapper.map(clienteCreateDTO, Cliente.class);
    }

    // Convierte Cliente a ClienteDTO
    public ClienteDTO toClienteDTO(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    // Convierte ClienteMetaCreateDTO a Meta
    public Meta toMetaEntity(ClienteMetaCreateDTO metaDTO) {
        Meta meta = modelMapper.map(metaDTO, Meta.class);
        Cliente cliente = new Cliente();
        cliente.setMeta(meta);
        meta.setCliente(cliente);
        return meta;
    }

    // Convierte Meta a ClienteMetaDTO
    public ClienteMetaDTO toMetaDTO(Meta meta) {
        return modelMapper.map(meta, ClienteMetaDTO.class);
    }

    // Convierte RecompensaCreateDTO a Recompensa
    public Recompensa toRecompensaEntity(RecompensaCreateDTO recompensaCreateDTO) {
        return modelMapper.map(recompensaCreateDTO, Recompensa.class);
    }

    // Convierte Recompensa a RecompensaDTO
    public RecompensaDTO toRecompensaDTO(Recompensa recompensa) {
        return modelMapper.map(recompensa, RecompensaDTO.class);
    }

    // Convierte ClienteHabitoCreateDTO a Habito
    public Habito toHabitoEntity(ClienteHabitoCreateDTO habitoCreateDTO) {
        return modelMapper.map(habitoCreateDTO, Habito.class);
    }

    // Convierte Habito a ClienteHabitoDTO
    public ClienteHabitoDTO toHabitoDTO(Habito habito) {
        return modelMapper.map(habito, ClienteHabitoDTO.class);
    }

    // Convierte ContenidoDTO a Contenido
    public Contenido toContenidoEntity(ContenidoDTO contenidoDTO) {
        return modelMapper.map(contenidoDTO, Contenido.class);
    }

    // Convierte Contenido a ContenidoDTO
    public ContenidoDTO toContenidoDTO(Contenido contenido) {
        return modelMapper.map(contenido, ContenidoDTO.class);
    }

    // Convierte PlanAlimenticioDTO a PlanAlimenticio
    public PlanAlimenticio toPlanAlimenticioEntity(PlanAlimenticioDTO planAlimenticioDTO) {
        return modelMapper.map(planAlimenticioDTO, PlanAlimenticio.class);
    }

    // Convierte PlanAlimenticio a PlanAlimenticioDTO
    public PlanAlimenticioDTO toPlanAlimenticioDTO(PlanAlimenticio planAlimenticio) {
        return modelMapper.map(planAlimenticio, PlanAlimenticioDTO.class);
    }
}