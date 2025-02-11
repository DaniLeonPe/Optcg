package es.system.danileonpe.springboot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.system.danileonpe.springboot.DTO.RolDTO;
import es.system.danileonpe.springboot.model.Rol;

@Mapper
public interface RolMapper {
    
    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    Rol  toEntity(RolDTO rolDto);
    
    RolDTO toDTO(Rol rolEntity);

    List<Rol> toEntityList(List<RolDTO> rolDtos);

    List<RolDTO> toDTOList(List<Rol> rolEntities);
}
