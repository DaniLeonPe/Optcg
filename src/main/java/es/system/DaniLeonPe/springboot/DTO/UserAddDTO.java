package es.system.danileonpe.springboot.DTO;

public record UserAddDTO(
    String nombreUsuario, 
    String contraseña, 
    String email, 
    int rol) {
}