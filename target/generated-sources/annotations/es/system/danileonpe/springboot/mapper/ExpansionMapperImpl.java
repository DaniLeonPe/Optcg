package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.ExpansionDTO;
import es.system.danileonpe.springboot.model.Expansion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T15:42:27+0000",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
public class ExpansionMapperImpl implements ExpansionMapper {

    @Override
    public ExpansionDTO toDTO(Expansion expansion) {
        if ( expansion == null ) {
            return null;
        }

        String nombre = null;
        Date fechaLanzamiento = null;

        nombre = expansion.getNombre();
        fechaLanzamiento = expansion.getFechaLanzamiento();

        int idExpansion = 0;

        ExpansionDTO expansionDTO = new ExpansionDTO( idExpansion, nombre, fechaLanzamiento );

        return expansionDTO;
    }

    @Override
    public Expansion toEntity(ExpansionDTO expansionDTO) {
        if ( expansionDTO == null ) {
            return null;
        }

        Expansion expansion = new Expansion();

        expansion.setNombre( expansionDTO.nombre() );
        expansion.setFechaLanzamiento( expansionDTO.fechaLanzamiento() );

        return expansion;
    }

    @Override
    public List<ExpansionDTO> toDTOList(List<Expansion> expansions) {
        if ( expansions == null ) {
            return null;
        }

        List<ExpansionDTO> list = new ArrayList<ExpansionDTO>( expansions.size() );
        for ( Expansion expansion : expansions ) {
            list.add( toDTO( expansion ) );
        }

        return list;
    }

    @Override
    public List<Expansion> toEntityList(List<ExpansionDTO> expansionDTOs) {
        if ( expansionDTOs == null ) {
            return null;
        }

        List<Expansion> list = new ArrayList<Expansion>( expansionDTOs.size() );
        for ( ExpansionDTO expansionDTO : expansionDTOs ) {
            list.add( toEntity( expansionDTO ) );
        }

        return list;
    }
}
