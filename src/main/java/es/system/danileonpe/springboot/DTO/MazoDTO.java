package es.system.danileonpe.springboot.DTO;

import java.time.LocalDateTime;

public record MazoDTO(
    int id,
    int idUsuario,
    String nombre,
    String descripcion,
    LocalDateTime fechaCreacion
) {
    
}
