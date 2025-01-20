package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.model.Usuario;
import es.system.danileonpe.springboot.service.UserServiceInterface;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Servicio SOAP para la gestión de usuarios.
 * Proporciona operaciones CRUD para la entidad Usuario.
 */
@Component
@WebService(endpointInterface = "es.system.danileonpe.springboot.soap.service.UserServiceSoapInterface")
public class UserServiceSoap implements UserServiceSoapInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceSoap.class);

    private UserServiceInterface userService;

    @Autowired
    public void setUserService(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    @WebMethod
    @WebResult(name = "usuario")
    public Usuario addUser(@WebParam(name = "usuario") Usuario usuario) {
        try {
            LOGGER.info("Creando un nuevo usuario: {}", usuario);
            return userService.createUser(usuario);
        } catch (Exception e) {
            LOGGER.error("Error al crear el usuario: {}", usuario, e);
            throw new WebServiceException("Error creando el usuario", e);
        }
    }

    @Override
    @WebMethod
    @WebResult(name = "usuario")
    public Usuario updateUser(@WebParam(name = "id") int id, @WebParam(name = "usuario") Usuario usuario) {
        try {
            LOGGER.info("Actualizando el usuario con ID {}: {}", id, usuario);
            return userService.updateUser(id, usuario);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar el usuario con ID {}: {}", id, usuario, e);
            throw new WebServiceException("Error actualizando el usuario", e);
        }
    }

    @Override
    @WebMethod
    @WebResult(name = "usuarios")
    public List<Usuario> getAllUsers() {
        try {
            LOGGER.info("Obteniendo todos los usuarios");
            return userService.getAllUsers();
        } catch (Exception e) {
            LOGGER.error("Error al obtener todos los usuarios", e);
            throw new WebServiceException("Error obteniendo los usuarios", e);
        }
    }

    @Override
    @WebMethod
    @WebResult(name = "usuario")
    public Usuario getUserById(@WebParam(name = "id") int id) {
        try {
            LOGGER.info("Obteniendo usuario con ID: {}", id);
            return userService.getUserById(id);
        } catch (Exception e) {
            LOGGER.error("Error al obtener el usuario con ID: {}", id, e);
            throw new WebServiceException("Error obteniendo el usuario", e);
        }
    }

    @Override
    @WebMethod
    public boolean deleteUser(@WebParam(name = "id") int id) {
        try {
            LOGGER.info("Eliminando usuario con ID: {}", id);
            userService.deleteUser(id);
            return true;
        } catch (Exception e) {
            LOGGER.error("Error al eliminar el usuario con ID: {}", id, e);
            throw new WebServiceException("Error eliminando el usuario", e);
        }
    }
}
