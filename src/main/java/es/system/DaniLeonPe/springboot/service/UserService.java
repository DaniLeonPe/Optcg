package es.system.danileonpe.springboot.service;

import java.util.List;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Usuario;
import es.system.danileonpe.springboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

/**
 * Servicio para la gestión de usuarios.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Usuario.
 */
@Component
public class UserService implements UserServiceInterface{

    private UsuarioRepository userRepository;

    /**
     * Inyección del repositorio de usuarios.
     *
     * @param userRepository Repositorio de usuarios.
     */
    @Autowired
    public void setUserRepository(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Obtiene todos los usuarios almacenados.
     *
     * @return Lista de usuarios.
     */
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param userId Identificador del usuario.
     * @return El usuario encontrado.
     * @throws ResourceNotFoundException Si no se encuentra el usuario con el ID proporcionado.
     */
    public Usuario getUserById(@PathVariable(value = "id") int userId) throws ResourceNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
    }

    /**
     * Crea un nuevo usuario.
     *
     * @param user Detalles del usuario a crear.
     * @return El usuario creado.
     */
    public Usuario createUser(@Valid @RequestBody Usuario user) {
        return userRepository.save(user);
    }


    /**
     * Actualiza un usuario existente.
     *
     * @param userId Identificador del usuario a actualizar.
     * @param userDetails Detalles actualizados del usuario.
     * @return El usuario actualizado.
     * @throws ResourceNotFoundException Si no se encuentra el usuario con el ID proporcionado.
     */
    public Usuario updateUser(@PathVariable(value = "id") int userId,
                              @Valid @RequestBody Usuario userDetails) throws ResourceNotFoundException {
        Usuario user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setNombreUsuario(userDetails.getNombreUsuario());
        return userRepository.save(user);
    }

    /**
     * Elimina un user por su ID.
     *
     * @param userId Identificador del user a eliminar.
     * @throws ResourceNotFoundException Si no se encuentra el user con el ID proporcionado.
     */
    public void deleteUser(@PathVariable(value = "id") int userId) throws ResourceNotFoundException {
        Usuario user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        userRepository.delete(user);
    }
    
}
