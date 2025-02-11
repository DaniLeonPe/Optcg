package es.system.danileonpe.springboot.DTO;

public record UsuarioDTO(
    int idUsuario,
    String nombreUsuario,
    String email,
    int rol
) {}
