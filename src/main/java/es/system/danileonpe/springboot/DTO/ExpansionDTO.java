package es.system.danileonpe.springboot.DTO;

import java.util.Date;

public record ExpansionDTO(
    int idExpansion,
    String nombre,
    Date fechaLanzamiento
) {
    
}
