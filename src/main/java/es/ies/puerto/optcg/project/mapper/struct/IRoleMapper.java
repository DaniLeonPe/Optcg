package es.ies.puerto.optcg.project.mapper.struct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.optcg.project.dto.RoleDTO;
import es.ies.puerto.optcg.project.model.entities.Role;

@Mapper
public interface IRoleMapper {
    IRoleMapper INSTANCE = Mappers.getMapper(IRoleMapper.class);

    Role toEntity(RoleDTO roleDTO);
    RoleDTO toDTO(Role role);
}
