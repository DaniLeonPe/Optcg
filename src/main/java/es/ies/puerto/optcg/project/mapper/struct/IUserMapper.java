package es.ies.puerto.optcg.project.mapper.struct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.optcg.project.dto.user.UserDTO;
import es.ies.puerto.optcg.project.model.entities.User;


@Mapper(uses = {IRoleMapper.class})
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User toEntity(UserDTO userDTO);
    @Mapping(target = "password", ignore = true)
    UserDTO toDTO(User user);
}
