package es.system.danileonpe.springboot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.system.danileonpe.springboot.DTO.ColeccionCartaDTO;
import es.system.danileonpe.springboot.model.ColeccionCarta;

@Mapper
public interface ColeccionCartaMapper {
    
    ColeccionCartaMapper INSTANCE = Mappers.getMapper(ColeccionCartaMapper.class);
    
    @Mapping(source = "coleccion.idColeccion", target = "idColeccion")
    @Mapping(source = "carta.idCarta", target = "idCarta")
    ColeccionCartaDTO toDTO(ColeccionCarta coleccionCarta);

    @Mapping(source = "idColeccion", target = "coleccion.idColeccion")
    @Mapping(source = "idCarta", target = "carta.idCarta")
    ColeccionCarta toEntity(ColeccionCartaDTO coleccionCartaDTO);

    List<ColeccionCartaDTO> toDTOList(List<ColeccionCarta> coleccionCartas);

    List<ColeccionCarta> toEntityList(List<ColeccionCartaDTO> coleccionCartaDTOs);
}
