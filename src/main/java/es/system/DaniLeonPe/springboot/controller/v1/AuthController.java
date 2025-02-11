package es.system.danileonpe.springboot.controller.v1;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import es.system.danileonpe.springboot.DTO.UsuarioDTO;
import es.system.danileonpe.springboot.model.Usuario;
import es.system.danileonpe.springboot.security.CustomUserDetailsService;
import es.system.danileonpe.springboot.security.JwtUtils;
import es.system.danileonpe.springboot.service.rest.RolService;
import es.system.danileonpe.springboot.service.rest.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
@Tag(name="v1", description="The authentication")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    private CustomUserDetailsService userDetailsService;
    private JwtUtils jwtUtils;
    private AuthenticationManager authenticationManager;
    private UserService service;
    private RolService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Autowired
    public void setCustomUserDetailsService(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }

    @Autowired
    public void setRoleService(RolService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            String token = jwtUtils.generateToken(userDetails.getUsername(), authorities);

            return ResponseEntity.ok(new JwtResponse(token));

        } catch (BadCredentialsException eb) {
            log.error("Invalid credentials error: {}", eb.getMessage());
        } catch (Exception e) {
            log.error("Unhandled error: {}", e.getMessage());
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String username, 
                                      @RequestParam String password, 
                                      @RequestParam String email) {
        
        if (service.getByName(username) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Name already in use");
        }
    
        if (service.getByEmail(email) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already in use");
        }
    
        Usuario newUser = new Usuario();
        newUser.setNombreUsuario(username);
        newUser.setEmail(email);
        newUser.setContraseña(passwordEncoder.encode(password));  // Encrypt password
        newUser.setRol(roleService.getById(2));  // Set default role
    
        service.add(newUser);
    
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
    }

    // DTO for returning JWT token in a response
    public static class JwtResponse {
        private String token;

        public JwtResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
