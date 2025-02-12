package es.system.danileonpe.springboot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.system.danileonpe.springboot.DTO.MazoCartaDTO;
import es.system.danileonpe.springboot.model.MazoCarta;

@Mapper
public interface MazoCartaMapper {
    
    MazoCartaMapper INSTANCE = Mappers.getMapper(MazoCartaMapper.class);

    @Mapping(source = "mazo.id", target = "idMazo")
    @Mapping(source = "carta.id", target = "idCarta")
    MazoCartaDTO toDTO(MazoCarta mazoCarta);


    @Mapping(source = "idMazo", target = "mazo.id")
    @Mapping(source = "idCarta", target = "carta.id")
    MazoCarta toEntity(MazoCartaDTO mazoCartaDTO);

    List<MazoCartaDTO> toDTOList(List<MazoCarta> mazoCartas);

    List<MazoCarta> toEntityList(List<MazoCartaDTO> mazoCartaDTOs);
}
