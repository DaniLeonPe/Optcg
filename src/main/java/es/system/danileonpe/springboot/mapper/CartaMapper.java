package es.system.danileonpe.springboot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.system.danileonpe.springboot.DTO.CartaDTO;
import es.system.danileonpe.springboot.model.Carta;

@Mapper
public interface CartaMapper {

    CartaMapper INSTANCE = Mappers.getMapper(CartaMapper.class);
    
    @Mapping(source = "expansion.id", target = "expansion")
    CartaDTO toDTO(Carta carta);

    @Mapping(source = "expansion", target = "expansion.id")
    Carta toEntity(CartaDTO cartaDTO);

    List<CartaDTO> toDTOList(List<Carta> cartas);
    
    List<Carta> toEntityList(List<CartaDTO> cartaDTOs);
}