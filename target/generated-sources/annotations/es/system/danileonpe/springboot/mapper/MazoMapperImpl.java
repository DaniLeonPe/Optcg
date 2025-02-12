package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.MazoDTO;
import es.system.danileonpe.springboot.model.Mazo;
import es.system.danileonpe.springboot.model.Usuario;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T19:36:25+0000",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
public class MazoMapperImpl implements MazoMapper {

    @Override
    public MazoDTO toDTO(Mazo mazo) {
        if ( mazo == null ) {
            return null;
        }

        int idUsuario = 0;
        int id = 0;
        String nombre = null;
        String descripcion = null;
        LocalDateTime fechaCreacion = null;

        idUsuario = mazoUsuarioId( mazo );
        id = mazo.getId();
        nombre = mazo.getNombre();
        descripcion = mazo.getDescripcion();
        if ( mazo.getFechaCreacion() != null ) {
            fechaCreacion = LocalDateTime.ofInstant( mazo.getFechaCreacion().toInstant(), ZoneId.of( "UTC" ) );
        }

        MazoDTO mazoDTO = new MazoDTO( id, idUsuario, nombre, descripcion, fechaCreacion );

        return mazoDTO;
    }

    @Override
    public Mazo toEntity(MazoDTO mazoDTO) {
        if ( mazoDTO == null ) {
            return null;
        }

        Mazo mazo = new Mazo();

        mazo.setUsuario( mazoDTOToUsuario( mazoDTO ) );
        mazo.setId( mazoDTO.id() );
        mazo.setNombre( mazoDTO.nombre() );
        mazo.setDescripcion( mazoDTO.descripcion() );
        if ( mazoDTO.fechaCreacion() != null ) {
            mazo.setFechaCreacion( Date.from( mazoDTO.fechaCreacion().toInstant( ZoneOffset.UTC ) ) );
        }

        return mazo;
    }

    @Override
    public List<MazoDTO> toDTOList(List<Mazo> mazos) {
        if ( mazos == null ) {
            return null;
        }

        List<MazoDTO> list = new ArrayList<MazoDTO>( mazos.size() );
        for ( Mazo mazo : mazos ) {
            list.add( toDTO( mazo ) );
        }

        return list;
    }

    @Override
    public List<Mazo> toEntityList(List<MazoDTO> mazoDTOs) {
        if ( mazoDTOs == null ) {
            return null;
        }

        List<Mazo> list = new ArrayList<Mazo>( mazoDTOs.size() );
        for ( MazoDTO mazoDTO : mazoDTOs ) {
            list.add( toEntity( mazoDTO ) );
        }

        return list;
    }

    private int mazoUsuarioId(Mazo mazo) {
        if ( mazo == null ) {
            return 0;
        }
        Usuario usuario = mazo.getUsuario();
        if ( usuario == null ) {
            return 0;
        }
        int id = usuario.getId();
        return id;
    }

    protected Usuario mazoDTOToUsuario(MazoDTO mazoDTO) {
        if ( mazoDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( mazoDTO.idUsuario() );

        return usuario;
    }
}
