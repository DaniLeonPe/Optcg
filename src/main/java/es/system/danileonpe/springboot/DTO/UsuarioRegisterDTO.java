package es.system.danileonpe.springboot.DTO;

public record UsuarioRegisterDTO(
        String nombreUsuario,
        String contraseña,
        String email
) {
}
