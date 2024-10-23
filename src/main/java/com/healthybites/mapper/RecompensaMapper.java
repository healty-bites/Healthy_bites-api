package com.healthybites.mapper;

import com.healthybites.dto.RecompensaCreateUpdateDTO;
import com.healthybites.dto.RecompensaDetailsDTO;
import com.healthybites.model.entity.Recompensa;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class RecompensaMapper {

    private final ModelMapper modelMapper;

    public RecompensaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public RecompensaDetailsDTO toDTO(Recompensa recompensa) {
        RecompensaDetailsDTO recompensaDetailsDTO = modelMapper.map(recompensa, RecompensaDetailsDTO.class);
        recompensaDetailsDTO.setNutricionistaNombre(recompensa.getNutricionista().getNombre() + " " + recompensa.getNutricionista().getApellido());
        return recompensaDetailsDTO;
    }

    public Recompensa toEntity(RecompensaCreateUpdateDTO recompensaCreateUpdateDTO) {
        return modelMapper.map(recompensaCreateUpdateDTO, Recompensa.class);
    }

    public RecompensaCreateUpdateDTO toCreateUpdateDTO(Recompensa recompensa) {
        return modelMapper.map(recompensa, RecompensaCreateUpdateDTO.class);
    }
}
