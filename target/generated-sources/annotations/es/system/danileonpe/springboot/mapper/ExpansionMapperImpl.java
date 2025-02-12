package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.ExpansionDTO;
import es.system.danileonpe.springboot.model.Expansion;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T19:52:26+0000",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class ExpansionMapperImpl implements ExpansionMapper {

    @Override
    public ExpansionDTO toDTO(Expansion expansion) {
        if ( expansion == null ) {
            return null;
        }

        ExpansionDTO expansionDTO = new ExpansionDTO();

        if ( expansion.getFechaLanzamiento() != null ) {
            expansionDTO.setFechaLanzamiento( LocalDateTime.ofInstant( expansion.getFechaLanzamiento().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        expansionDTO.setId( expansion.getId() );
        expansionDTO.setNombre( expansion.getNombre() );

        return expansionDTO;
    }

    @Override
    public Expansion toEntity(ExpansionDTO expansionDTO) {
        if ( expansionDTO == null ) {
            return null;
        }

        Expansion expansion = new Expansion();

        if ( expansionDTO.getFechaLanzamiento() != null ) {
            expansion.setFechaLanzamiento( Date.from( expansionDTO.getFechaLanzamiento().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }
        expansion.setId( expansionDTO.getId() );
        expansion.setNombre( expansionDTO.getNombre() );

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
