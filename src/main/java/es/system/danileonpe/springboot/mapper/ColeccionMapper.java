package es.system.danileonpe.springboot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.system.danileonpe.springboot.DTO.ColeccionDTO;
import es.system.danileonpe.springboot.model.Coleccion;

@Mapper(componentModel = "spring")
public interface ColeccionMapper {
    
    ColeccionMapper INSTANCE = Mappers.getMapper(ColeccionMapper.class);

    @Mapping(source = "usuario.idUsuario", target = "usuario")
    @Mapping(source = "carta.idCarta", target = "carta")
    ColeccionDTO toDTO(Coleccion coleccion);
    
    @Mapping(target = "usuario", expression = "java(new Usuario(coleccionDTO.usuario()))")
    @Mapping(target = "carta", expression = "java(new Carta(coleccionDTO.carta()))")
    Coleccion toEntity(ColeccionDTO coleccionDTO);

    List<ColeccionDTO> toDTOList(List<Coleccion> colecciones);

    List<Coleccion> toEntityList(List<ColeccionDTO> coleccionDTOs);
    
}
