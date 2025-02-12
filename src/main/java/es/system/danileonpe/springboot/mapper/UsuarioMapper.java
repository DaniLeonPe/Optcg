package es.system.danileonpe.springboot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.system.danileonpe.springboot.DTO.UsuarioDTO;
import es.system.danileonpe.springboot.model.Usuario;

@Mapper
public interface UsuarioMapper {
    
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "role.id", target = "role")
    UsuarioDTO toDTO(Usuario usuario);

    @Mapping(source = "role", target = "role.id")
    @Mapping(target = "password", ignore = true)

    Usuario toEntity(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> toDTOList(List<Usuario> usuarios);
    
    List<Usuario> toEntityList(List<UsuarioDTO> usuarioDTOs);
}
