package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.ColeccionDTO;
import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.model.Coleccion;
import es.system.danileonpe.springboot.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-10T11:03:29+0000",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
@Component
public class ColeccionMapperImpl implements ColeccionMapper {

    @Override
    public ColeccionDTO toDTO(Coleccion coleccion) {
        if ( coleccion == null ) {
            return null;
        }

        int usuario = 0;
        int carta = 0;
        int idColeccion = 0;
        int cantidad = 0;

        Integer idUsuario = coleccionUsuarioIdUsuario( coleccion );
        if ( idUsuario != null ) {
            usuario = idUsuario;
        }
        carta = coleccionCartaIdCarta( coleccion );
        idColeccion = coleccion.getIdColeccion();
        cantidad = coleccion.getCantidad();

        ColeccionDTO coleccionDTO = new ColeccionDTO( idColeccion, usuario, carta, cantidad );

        return coleccionDTO;
    }

    @Override
    public Coleccion toEntity(ColeccionDTO coleccionDTO) {
        if ( coleccionDTO == null ) {
            return null;
        }

        Coleccion coleccion = new Coleccion();

        coleccion.setIdColeccion( coleccionDTO.idColeccion() );
        coleccion.setCantidad( coleccionDTO.cantidad() );

        coleccion.setUsuario( new Usuario(coleccionDTO.usuario()) );
        coleccion.setCarta( new Carta(coleccionDTO.carta()) );

        return coleccion;
    }

    @Override
    public List<ColeccionDTO> toDTOList(List<Coleccion> colecciones) {
        if ( colecciones == null ) {
            return null;
        }

        List<ColeccionDTO> list = new ArrayList<ColeccionDTO>( colecciones.size() );
        for ( Coleccion coleccion : colecciones ) {
            list.add( toDTO( coleccion ) );
        }

        return list;
    }

    @Override
    public List<Coleccion> toEntityList(List<ColeccionDTO> coleccionDTOs) {
        if ( coleccionDTOs == null ) {
            return null;
        }

        List<Coleccion> list = new ArrayList<Coleccion>( coleccionDTOs.size() );
        for ( ColeccionDTO coleccionDTO : coleccionDTOs ) {
            list.add( toEntity( coleccionDTO ) );
        }

        return list;
    }

    private Integer coleccionUsuarioIdUsuario(Coleccion coleccion) {
        if ( coleccion == null ) {
            return null;
        }
        Usuario usuario = coleccion.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Integer idUsuario = usuario.getIdUsuario();
        if ( idUsuario == null ) {
            return null;
        }
        return idUsuario;
    }

    private int coleccionCartaIdCarta(Coleccion coleccion) {
        if ( coleccion == null ) {
            return 0;
        }
        Carta carta = coleccion.getCarta();
        if ( carta == null ) {
            return 0;
        }
        int idCarta = carta.getIdCarta();
        return idCarta;
    }
}
