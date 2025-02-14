package es.ies.puerto.optcg.project.mapper.struct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.optcg.project.dto.ExpansionDTO;
import es.ies.puerto.optcg.project.model.entities.Expansion;



@Mapper(componentModel = "spring") 
public interface ExpansionMapper {
    
    ExpansionMapper INSTANCE = Mappers.getMapper(ExpansionMapper.class);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "fechaLanzamiento", target = "fechaLanzamiento")
    ExpansionDTO toDTO(Expansion expansion);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "fechaLanzamiento", target = "fechaLanzamiento")
    Expansion toEntity(ExpansionDTO expansionDTO);

    List<ExpansionDTO> toDTOList(List<Expansion> expansions);

    List<Expansion> toEntityList(List<ExpansionDTO> expansionDTOs);
}
