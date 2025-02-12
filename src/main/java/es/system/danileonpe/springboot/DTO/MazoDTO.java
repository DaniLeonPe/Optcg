package es.system.danileonpe.springboot.DTO;

import java.util.Date;

public record MazoDTO(
    int idMazo,
    int idUsuario,
    String nombre,
    String descripcion,
    Date fechaCreacion
) {
    
}
