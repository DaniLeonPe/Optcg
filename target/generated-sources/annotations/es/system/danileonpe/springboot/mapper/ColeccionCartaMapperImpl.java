package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.ColeccionCartaDTO;
import es.system.danileonpe.springboot.model.ColeccionCarta;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T13:24:04+0000",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class ColeccionCartaMapperImpl implements ColeccionCartaMapper {

    @Override
    public ColeccionCarta toEntity(ColeccionCartaDTO coleccionCartaDTO) {
        if ( coleccionCartaDTO == null ) {
            return null;
        }

        ColeccionCarta coleccionCarta = new ColeccionCarta();

        coleccionCarta.setId( coleccionCartaDTO.id() );
        coleccionCarta.setCantidad( coleccionCartaDTO.cantidad() );

        return coleccionCarta;
    }

    @Override
    public ColeccionCartaDTO toDTO(ColeccionCarta coleccionCarta) {
        if ( coleccionCarta == null ) {
            return null;
        }

        int id = 0;
        int cantidad = 0;

        id = coleccionCarta.getId();
        cantidad = coleccionCarta.getCantidad();

        int idColeccion = 0;
        int idCarta = 0;

        ColeccionCartaDTO coleccionCartaDTO = new ColeccionCartaDTO( id, idColeccion, idCarta, cantidad );

        return coleccionCartaDTO;
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
}
