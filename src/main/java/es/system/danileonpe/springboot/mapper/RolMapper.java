package es.system.danileonpe.springboot.mapper;

import java.util.List;

import es.system.danileonpe.springboot.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.system.danileonpe.springboot.DTO.RolDTO;

@Mapper
public interface RolMapper {
    
    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    Role toEntity(RolDTO rolDto);
    
    RolDTO toDTO(Role rolEntity);

    List<Role> toEntityList(List<RolDTO> rolDtos);

    List<RolDTO> toDTOList(List<Role> rolEntities);
}
