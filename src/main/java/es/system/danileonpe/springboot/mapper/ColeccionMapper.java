package es.system.danileonpe.springboot.mapper;

import java.util.List;

import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.system.danileonpe.springboot.DTO.ColeccionDTO;
import es.system.danileonpe.springboot.model.Coleccion;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, CartaMapper.class})
public interface ColeccionMapper {

    ColeccionMapper INSTANCE = Mappers.getMapper(ColeccionMapper.class);

    @Mapping(source = "usuario.id", target = "usuario")  // Usa el ID para obtener el Usuario
    @Mapping(source = "carta.id", target = "carta")  // Usa el ID para obtener la Carta
    ColeccionDTO toDTO(Coleccion coleccion);

    @Mapping(target = "usuario", expression = "java(mapUsuario(coleccionDTO.usuario()))")  // Mapea ID de Usuario
    @Mapping(target = "carta", expression = "java(mapCarta(coleccionDTO.carta()))")  // Mapea ID de Carta
    Coleccion toEntity(ColeccionDTO coleccionDTO);

    List<ColeccionDTO> toDTOList(List<Coleccion> colecciones);

    List<Coleccion> toEntityList(List<ColeccionDTO> coleccionDTOs);

    // Método para mapear el ID de Usuario a Usuario
    default Usuario mapUsuario(int id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);  // Solo seteamos el ID en este ejemplo
        return usuario;
    }

    // Método para mapear el ID de Carta a Carta
    default Carta mapCarta(int id) {
        Carta carta = new Carta();
        carta.setId(id);  // Solo seteamos el ID en este ejemplo
        return carta;
    }
}
