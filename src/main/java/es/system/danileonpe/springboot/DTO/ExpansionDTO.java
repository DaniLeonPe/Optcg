package es.system.danileonpe.springboot.DTO;

import java.sql.Date;

public record ExpansionDTO(
    int idExpansion,
    String nombre,
    Date fechaLanzamiento
) {
    
}
