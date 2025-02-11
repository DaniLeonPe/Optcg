package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.ColeccionCartaDTO;
import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.model.Coleccion;
import es.system.danileonpe.springboot.model.ColeccionCarta;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-11T17:04:07+0000",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.2 (Private Build)"
)
public class ColeccionCartaMapperImpl implements ColeccionCartaMapper {

    @Override
    public ColeccionCartaDTO toDTO(ColeccionCarta coleccionCarta) {
        if ( coleccionCarta == null ) {
            return null;
        }

        int idColeccion = 0;
        int idCarta = 0;
        int id = 0;
        int cantidad = 0;

        idColeccion = coleccionCartaColeccionIdColeccion( coleccionCarta );
        idCarta = coleccionCartaCartaIdCarta( coleccionCarta );
        id = coleccionCarta.getId();
        cantidad = coleccionCarta.getCantidad();

        ColeccionCartaDTO coleccionCartaDTO = new ColeccionCartaDTO( id, idColeccion, idCarta, cantidad );

        return coleccionCartaDTO;
    }

    @Override
    public ColeccionCarta toEntity(ColeccionCartaDTO coleccionCartaDTO) {
        if ( coleccionCartaDTO == null ) {
            return null;
        }

        ColeccionCarta coleccionCarta = new ColeccionCarta();

        coleccionCarta.setColeccion( coleccionCartaDTOToColeccion( coleccionCartaDTO ) );
        coleccionCarta.setCarta( coleccionCartaDTOToCarta( coleccionCartaDTO ) );
        coleccionCarta.setId( coleccionCartaDTO.id() );
        coleccionCarta.setCantidad( coleccionCartaDTO.cantidad() );

        return coleccionCarta;
    }

    @Override
    public List<ColeccionCartaDTO> toDTOList(List<ColeccionCarta> coleccionCartas) {
        if ( coleccionCartas == null ) {
            return null;
        }

        List<ColeccionCartaDTO> list = new ArrayList<ColeccionCartaDTO>( coleccionCartas.size() );
        for ( ColeccionCarta coleccionCarta : coleccionCartas ) {
            list.add( toDTO( coleccionCarta ) );
        }

        return list;
    }

    @Override
    public List<ColeccionCarta> toEntityList(List<ColeccionCartaDTO> coleccionCartaDTOs) {
        if ( coleccionCartaDTOs == null ) {
            return null;
        }

        List<ColeccionCarta> list = new ArrayList<ColeccionCarta>( coleccionCartaDTOs.size() );
        for ( ColeccionCartaDTO coleccionCartaDTO : coleccionCartaDTOs ) {
            list.add( toEntity( coleccionCartaDTO ) );
        }

        return list;
    }

    private int coleccionCartaColeccionIdColeccion(ColeccionCarta coleccionCarta) {
        if ( coleccionCarta == null ) {
            return 0;
        }
        Coleccion coleccion = coleccionCarta.getColeccion();
        if ( coleccion == null ) {
            return 0;
        }
        int idColeccion = coleccion.getIdColeccion();
        return idColeccion;
    }

    private int coleccionCartaCartaIdCarta(ColeccionCarta coleccionCarta) {
        if ( coleccionCarta == null ) {
            return 0;
        }
        Carta carta = coleccionCarta.getCarta();
        if ( carta == null ) {
            return 0;
        }
        int idCarta = carta.getIdCarta();
        return idCarta;
    }

    protected Coleccion coleccionCartaDTOToColeccion(ColeccionCartaDTO coleccionCartaDTO) {
        if ( coleccionCartaDTO == null ) {
            return null;
        }

        Coleccion coleccion = new Coleccion();

        coleccion.setIdColeccion( coleccionCartaDTO.idColeccion() );

        return coleccion;
    }

    protected Carta coleccionCartaDTOToCarta(ColeccionCartaDTO coleccionCartaDTO) {
        if ( coleccionCartaDTO == null ) {
            return null;
        }

        Carta carta = new Carta();

        carta.setIdCarta( coleccionCartaDTO.idCarta() );

        return carta;
    }
}
