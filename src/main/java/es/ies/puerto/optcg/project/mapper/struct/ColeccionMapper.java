package es.ies.puerto.optcg.project.mapper.struct;

import java.util.List;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.optcg.project.dto.ColeccionDTO;
import es.ies.puerto.optcg.project.model.entities.Carta;
import es.ies.puerto.optcg.project.model.entities.Coleccion;
import es.ies.puerto.optcg.project.model.entities.User;



@Mapper(componentModel = "spring")
public interface ColeccionMapper {

    ColeccionMapper INSTANCE = Mappers.getMapper(ColeccionMapper.class);

    @Mapping(source = "usuario.id", target = "usuario")  // Usa el ID para obtener el Usuario
    @Mapping(source = "carta.id", target = "carta")  // Usa el ID para obtener la Carta
    ColeccionDTO toDTO(Coleccion coleccion);

    @Mapping(target = "usuario", expression = "java(mapUsuario(coleccionDTO.getUsuario()))")  // Mapea ID de Usuario
    @Mapping(target = "carta", expression = "java(mapCarta(coleccionDTO.getCarta()))")  // Mapea ID de Carta
    Coleccion toEntity(ColeccionDTO coleccionDTO);

    List<ColeccionDTO> toDTOList(List<Coleccion> colecciones);

    List<Coleccion> toEntityList(List<ColeccionDTO> coleccionDTOs);

    // Método para mapear el ID de Usuario a Usuario
    default User mapUsuario(int id) {
        User usuario = new User();
        usuario.setId(id); 
        return usuario;
    }

    // Método para mapear el ID de Carta a Carta
    default Carta mapCarta(int id) {
        Carta carta = new Carta();
        carta.setId(id); 
        return carta;
    }
}
