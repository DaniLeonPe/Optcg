package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.ExpansionDTO;
import es.system.danileonpe.springboot.model.Expansion;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-11T17:04:07+0000",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.2 (Private Build)"
)
public class ExpansionMapperImpl implements ExpansionMapper {

    @Override
    public ExpansionDTO toDTO(Expansion expansion) {
        if ( expansion == null ) {
            return null;
        }

        int idExpansion = 0;
        String nombre = null;
        Date fechaLanzamiento = null;

        idExpansion = expansion.getIdExpansion();
        nombre = expansion.getNombre();
        if ( expansion.getFechaLanzamiento() != null ) {
            fechaLanzamiento = new Date( expansion.getFechaLanzamiento().getTime() );
        }

        ExpansionDTO expansionDTO = new ExpansionDTO( idExpansion, nombre, fechaLanzamiento );

        return expansionDTO;
    }

    @Override
    public Expansion toEntity(ExpansionDTO expansionDTO) {
        if ( expansionDTO == null ) {
            return null;
        }

        Expansion expansion = new Expansion();

        expansion.setIdExpansion( expansionDTO.idExpansion() );
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
