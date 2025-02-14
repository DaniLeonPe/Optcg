package es.ies.puerto.optcg.project.dto;

import java.time.LocalDateTime;

public record MazoDTO(
    int id,
    int idUsuario,
    String nombre,
    String descripcion,
    LocalDateTime fechaCreacion
) {
    
}
