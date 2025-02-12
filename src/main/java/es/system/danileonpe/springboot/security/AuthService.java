package es.system.danileonpe.springboot.security;

import es.system.danileonpe.springboot.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import es.system.danileonpe.springboot.model.Usuario;
import es.system.danileonpe.springboot.service.rest.RolService;
import es.system.danileonpe.springboot.service.rest.UserService;

@Service
public class AuthService {
    /**
     * Properties
     */

    private UserService service;

    private RolService rolService;

    private JwtService jwtService;


    private PasswordEncoder passwordEncoder;

    /**
     * Setters of the user service
     * @param service of the user
     */
    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    /**
     * Setters of the user service
     * @param rolService of the role
     */
    @Autowired
    public void setRoleService(RolService rolService) {
        this.rolService = rolService;
    }

    /**
     * Setters of the user service
     * @param jwtService of the role
     */
    @Autowired
    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    /**
     * Setters of the user service
     * @param passwordEncoder of the role
     */
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Function to register a new user
     * @param username of the user
     * @param password of the user
     * @param email of the user
     * @return the user if everything OK, null otherwise
     */
    public Usuario register(String username, String password, String email) {
        Usuario user = new Usuario();
        user.setName(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        Role role = rolService.getById(2);
        user.setRole(role);
        service.add(user);

        return service.getByName(username);

    }

    /**
     * Funcion para autenticar un User de cara al login
     * @param username del User
     * @param password del User
     * @return token si la autenticacion fue exitosa, null si algo fue mal
     */
    public String authenticate(String username, String password)  {
        String generateToken = null;
        Usuario user = service.getByName(username);

        System.out.println(user);

        if (user != null) {
            System.out.println(password);
            if (passwordEncoder.matches(password, user.getPassword())) {
                generateToken = jwtService.generateToken(user.getName(), user.getRole().getName());
            }
        }

        System.out.println(generateToken);

        return generateToken;
    }
}