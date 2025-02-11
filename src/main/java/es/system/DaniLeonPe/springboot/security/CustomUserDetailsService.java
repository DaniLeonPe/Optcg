package es.system.danileonpe.springboot.security;

import es.system.danileonpe.springboot.model.Usuario;
import es.system.danileonpe.springboot.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private UsuarioRepository userRepository;

    @Autowired
    public void setUsuarioRepository(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository.findByNombreUsuario(username)
                .orElseThrow("Usuario no encontrado: " + username);

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getNombreUsuario())
                .password(user.getContraseña()) 
                .authorities(user.getRol().getName().toUpperCase()) 
                .build();
    }
}
