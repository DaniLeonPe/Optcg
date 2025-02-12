package es.system.danileonpe.springboot.DTO;

public record UsuarioDTO(
    int id,
    String name,
    String email,
    int role
) {}
