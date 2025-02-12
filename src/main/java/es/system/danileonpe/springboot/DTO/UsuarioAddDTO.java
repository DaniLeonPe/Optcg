package es.system.danileonpe.springboot.DTO;

public record UsuarioAddDTO(
        String name,
        String email,
        String password,
        int role
) {
}
