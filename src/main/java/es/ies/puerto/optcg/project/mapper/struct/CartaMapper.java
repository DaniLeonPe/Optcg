package es.ies.puerto.optcg.project.mapper.struct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.optcg.project.dto.CartaDTO;
import es.ies.puerto.optcg.project.model.entities.Carta;



@Mapper(componentModel = "spring")
public interface CartaMapper {

    CartaMapper INSTANCE = Mappers.getMapper(CartaMapper.class);
    
    @Mapping(source = "expansion.id", target = "expansion")
    CartaDTO toDTO(Carta carta);

    @Mapping(source = "expansion", target = "expansion.id")
    Carta toEntity(CartaDTO cartaDTO);

    List<CartaDTO> toDTOList(List<Carta> cartas);
    
    List<Carta> toEntityList(List<CartaDTO> cartaDTOs);
}