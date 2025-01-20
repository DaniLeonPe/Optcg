package es.system.danileonpe.springboot.service;

import java.util.List;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Usuario;

public interface UserServiceInterface {
    List<Usuario> getAllUsers();
    Usuario getUserById(int userId) throws ResourceNotFoundException;
    public Usuario createUser(Usuario user);
    Usuario updateUser(int userId, Usuario userDetails)       throws ResourceNotFoundException;
    void deleteUser(int userId) throws ResourceNotFoundException;
}
