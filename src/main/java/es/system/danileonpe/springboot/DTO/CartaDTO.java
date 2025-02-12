package es.system.danileonpe.springboot.DTO;


public record CartaDTO(
    int id,
    String nombre,
    String tipo,
    String rareza,
    int costo,
    String descripcion,
    int expansion,
    String imagenUrl
) {

    
}
