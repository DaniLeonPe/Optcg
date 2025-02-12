package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.UsuarioDTO;
import es.system.danileonpe.springboot.model.Role;
import es.system.danileonpe.springboot.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T19:36:25+0000",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        int role = 0;
        int id = 0;
        String name = null;
        String email = null;

        role = usuarioRoleId( usuario );
        id = usuario.getId();
        name = usuario.getName();
        email = usuario.getEmail();

        UsuarioDTO usuarioDTO = new UsuarioDTO( id, name, email, role );

        return usuarioDTO;
    }

    @Override
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setRole( usuarioDTOToRole( usuarioDTO ) );
        usuario.setId( usuarioDTO.id() );
        usuario.setName( usuarioDTO.name() );
        usuario.setEmail( usuarioDTO.email() );

        return usuario;
    }

    @Override
    public List<UsuarioDTO> toDTOList(List<Usuario> usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( usuarios.size() );
        for ( Usuario usuario : usuarios ) {
            list.add( toDTO( usuario ) );
        }

        return list;
    }

    @Override
    public List<Usuario> toEntityList(List<UsuarioDTO> usuarioDTOs) {
        if ( usuarioDTOs == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( usuarioDTOs.size() );
        for ( UsuarioDTO usuarioDTO : usuarioDTOs ) {
            list.add( toEntity( usuarioDTO ) );
        }

        return list;
    }

    private int usuarioRoleId(Usuario usuario) {
        if ( usuario == null ) {
            return 0;
        }
        Role role = usuario.getRole();
        if ( role == null ) {
            return 0;
        }
        int id = role.getId();
        return id;
    }

    protected Role usuarioDTOToRole(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( usuarioDTO.role() );

        return role;
    }
}
