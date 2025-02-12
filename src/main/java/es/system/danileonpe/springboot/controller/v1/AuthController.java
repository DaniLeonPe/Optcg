package es.system.danileonpe.springboot.controller.v1;

import java.util.Collection;

import es.system.danileonpe.springboot.DTO.UsuarioLoginDTO;
import es.system.danileonpe.springboot.DTO.UsuarioRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import es.system.danileonpe.springboot.DTO.UsuarioDTO;
import es.system.danileonpe.springboot.model.Usuario;
import es.system.danileonpe.springboot.security.AuthService;
import es.system.danileonpe.springboot.security.JwtService;
import es.system.danileonpe.springboot.service.rest.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
@Tag(name="v1", description="The authentication")
public class AuthController {

    /**
     * Properties
     */
    private UserService service;

    private JwtService jwtService;

    private AuthService authService;

    /**
     * Setter of the user service
     * @param service of the user
     */
    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    /**
     * Setter of the jwt service
     * @param jwtService for the user
     */
    @Autowired
    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }


    /**
     * Setter of the jwt service
     * @param authService for the user
     */
    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioLoginDTO loginDTO ) {
        String token = authService.authenticate(loginDTO.nombreUsuario(), loginDTO.contraseña());

        if (token == null) {
            throw new RuntimeException("Credenciales inválidas");
        }

        return token;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsuarioRegisterDTO registerDTO ) {
        Usuario register = authService.register(registerDTO.nombreUsuario(), registerDTO.contraseña(), registerDTO.email());


        if (register != null) {

            UsuarioDTO dto = new UsuarioDTO(register.getId(), register.getName(), register.getEmail(), register.getRole().getId());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("success");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("error");
    }
}