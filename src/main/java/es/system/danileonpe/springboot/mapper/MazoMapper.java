package es.system.danileonpe.springboot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.system.danileonpe.springboot.DTO.MazoDTO;
import es.system.danileonpe.springboot.model.Mazo;

@Mapper
public interface MazoMapper {
    
    MazoMapper INSTANCE = Mappers.getMapper(MazoMapper.class); 

    @Mapping(source = "usuario.id", target = "idUsuario")
    MazoDTO toDTO(Mazo mazo);

    @Mapping(source = "idUsuario", target = "usuario.id")
    Mazo toEntity(MazoDTO mazoDTO);

    List<MazoDTO> toDTOList(List<Mazo> mazos);

    List<Mazo> toEntityList(List<MazoDTO> mazoDTOs);
}
