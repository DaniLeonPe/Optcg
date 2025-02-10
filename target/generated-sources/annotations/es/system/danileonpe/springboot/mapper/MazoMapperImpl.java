package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.MazoDTO;
import es.system.danileonpe.springboot.model.Mazo;
import es.system.danileonpe.springboot.model.Usuario;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-10T11:03:30+0000",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
public class MazoMapperImpl implements MazoMapper {

    @Override
    public MazoDTO toDTO(Mazo mazo) {
        if ( mazo == null ) {
            return null;
        }

        int idUsuario = 0;
        int idMazo = 0;
        String nombre = null;
        String descripcion = null;
        Date fechaCreacion = null;

        Integer idUsuario1 = mazoUsuarioIdUsuario( mazo );
        if ( idUsuario1 != null ) {
            idUsuario = idUsuario1;
        }
        idMazo = mazo.getIdMazo();
        nombre = mazo.getNombre();
        descripcion = mazo.getDescripcion();
        if ( mazo.getFechaCreacion() != null ) {
            fechaCreacion = new Date( mazo.getFechaCreacion().getTime() );
        }

        MazoDTO mazoDTO = new MazoDTO( idMazo, idUsuario, nombre, descripcion, fechaCreacion );

        return mazoDTO;
    }

    @Override
    public Mazo toEntity(MazoDTO mazoDTO) {
        if ( mazoDTO == null ) {
            return null;
        }

        Mazo mazo = new Mazo();

        mazo.setUsuario( mazoDTOToUsuario( mazoDTO ) );
        mazo.setIdMazo( mazoDTO.idMazo() );
        mazo.setNombre( mazoDTO.nombre() );
        mazo.setDescripcion( mazoDTO.descripcion() );
        mazo.setFechaCreacion( mazoDTO.fechaCreacion() );

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

    private Integer mazoUsuarioIdUsuario(Mazo mazo) {
        if ( mazo == null ) {
            return null;
        }
        Usuario usuario = mazo.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Integer idUsuario = usuario.getIdUsuario();
        if ( idUsuario == null ) {
            return null;
        }
        return idUsuario;
    }

    protected Usuario mazoDTOToUsuario(MazoDTO mazoDTO) {
        if ( mazoDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setIdUsuario( mazoDTO.idUsuario() );

        return usuario;
    }
}
