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
    date = "2025-02-12T15:42:27+0000",
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
        int cantidad = 0;

        usuario = coleccionUsuarioId( coleccion );
        carta = coleccionCartaId( coleccion );
        cantidad = coleccion.getCantidad();

        int idColeccion = 0;

        ColeccionDTO coleccionDTO = new ColeccionDTO( idColeccion, usuario, carta, cantidad );

        return coleccionDTO;
    }

    @Override
    public Coleccion toEntity(ColeccionDTO coleccionDTO) {
        if ( coleccionDTO == null ) {
            return null;
        }

        Coleccion coleccion = new Coleccion();

        coleccion.setCantidad( coleccionDTO.cantidad() );

        coleccion.setUsuario( mapUsuario(coleccionDTO.usuario()) );
        coleccion.setCarta( mapCarta(coleccionDTO.carta()) );

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

    private int coleccionUsuarioId(Coleccion coleccion) {
        if ( coleccion == null ) {
            return 0;
        }
        Usuario usuario = coleccion.getUsuario();
        if ( usuario == null ) {
            return 0;
        }
        int id = usuario.getId();
        return id;
    }

    private int coleccionCartaId(Coleccion coleccion) {
        if ( coleccion == null ) {
            return 0;
        }
        Carta carta = coleccion.getCarta();
        if ( carta == null ) {
            return 0;
        }
        int id = carta.getId();
        return id;
    }
}
