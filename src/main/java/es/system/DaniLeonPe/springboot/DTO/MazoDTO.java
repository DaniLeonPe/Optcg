package es.system.danileonpe.springboot.DTO;

import java.sql.Date;

public record MazoDTO(
    int idMazo,
    int idUsuario,
    String nombre,
    String descripcion,
    Date fechaCreacion
) {
    
}
