package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.UsuarioDTO;
import es.system.danileonpe.springboot.model.Role;
import es.system.danileonpe.springboot.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T13:24:04+0000",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        int role = 0;
        String email = null;

        role = usuarioRoleId( usuario );
        email = usuario.getEmail();

        int idUsuario = 0;
        String nombreUsuario = null;

        UsuarioDTO usuarioDTO = new UsuarioDTO( idUsuario, nombreUsuario, email, role );

        return usuarioDTO;
    }

    @Override
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setRole( usuarioDTOToRole( usuarioDTO ) );
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
