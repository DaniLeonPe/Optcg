package es.system.danileonpe.springboot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.system.danileonpe.springboot.DTO.ColeccionCartaDTO;
import es.system.danileonpe.springboot.model.ColeccionCarta;

@Mapper(componentModel = "spring")
public interface ColeccionCartaMapper {
    
    ColeccionCartaMapper INSTANCE = Mappers.getMapper(ColeccionCartaMapper.class);


    ColeccionCarta toEntity(ColeccionCartaDTO coleccionCartaDTO);


    ColeccionCartaDTO toDTO(ColeccionCarta coleccionCarta);

    List<ColeccionCartaDTO> toDTOList(List<ColeccionCarta> coleccionCartas);

    List<ColeccionCarta> toEntityList(List<ColeccionCartaDTO> coleccionCartaDTOs);
}
