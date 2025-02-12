package es.system.danileonpe.springboot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.system.danileonpe.springboot.DTO.ExpansionDTO;
import es.system.danileonpe.springboot.model.Expansion;

@Mapper(componentModel = "spring") 
public interface ExpansionMapper {
    
    ExpansionMapper INSTANCE = Mappers.getMapper(ExpansionMapper.class);


    
    
    ExpansionDTO toDTO(Expansion expansion);

   
    Expansion toEntity(ExpansionDTO expansionDTO);

    List<ExpansionDTO> toDTOList(List<Expansion> expansions);

    List<Expansion> toEntityList(List<ExpansionDTO> expansionDTOs);
}
