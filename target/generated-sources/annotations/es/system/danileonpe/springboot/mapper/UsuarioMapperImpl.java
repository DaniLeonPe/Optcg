package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.UsuarioDTO;
import es.system.danileonpe.springboot.model.Rol;
import es.system.danileonpe.springboot.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-10T11:03:30+0000",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        int rol = 0;
        int idUsuario = 0;
        String nombreUsuario = null;
        String email = null;

        rol = usuarioRolId( usuario );
        if ( usuario.getIdUsuario() != null ) {
            idUsuario = usuario.getIdUsuario();
        }
        nombreUsuario = usuario.getNombreUsuario();
        email = usuario.getEmail();

        UsuarioDTO usuarioDTO = new UsuarioDTO( idUsuario, nombreUsuario, email, rol );

        return usuarioDTO;
    }

    @Override
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setRol( usuarioDTOToRol( usuarioDTO ) );
        usuario.setIdUsuario( usuarioDTO.idUsuario() );
        usuario.setNombreUsuario( usuarioDTO.nombreUsuario() );
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

    private int usuarioRolId(Usuario usuario) {
        if ( usuario == null ) {
            return 0;
        }
        Rol rol = usuario.getRol();
        if ( rol == null ) {
            return 0;
        }
        int id = rol.getId();
        return id;
    }

    protected Rol usuarioDTOToRol(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Rol rol = new Rol();

        rol.setId( usuarioDTO.rol() );

        return rol;
    }
}
