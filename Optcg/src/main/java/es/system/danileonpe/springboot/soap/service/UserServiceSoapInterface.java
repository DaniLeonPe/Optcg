package es.system.danileonpe.springboot.soap.service;

import java.util.List;
import es.system.danileonpe.springboot.model.Usuario;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

/**
 * Interfaz del servicio SOAP para la gestión de usuarios.
 * Define las operaciones disponibles para CRUD de usuarios.
 */
@WebService(targetNamespace = "http://springboot.soap.service")
public interface UserServiceSoapInterface {

    /**
     * Obtiene la lista de todos los usuarios.
     *
     * @return Lista de usuarios.
     */
    @WebMethod(operationName = "getAllUsers")
    @WebResult(name = "users")
    List<Usuario> getAllUsers();

    /**
     * Obtiene un usuario por su ID.
     *
     * @param userId ID del usuario.
     * @return Usuario encontrado.
     */
    @WebMethod(operationName = "getUserById")
    @WebResult(name = "user")
    Usuario getUserById(@WebParam(name = "userId") int userId);

    /**
     * Crea un nuevo usuario.
     *
     * @param usuario Datos del usuario a crear.
     * @return Usuario creado.
     */
    @WebMethod(operationName = "addUser")
    @WebResult(name = "user")
    Usuario addUser(@WebParam(name = "usuario") Usuario usuario);

    /**
     * Actualiza un usuario existente.
     *
     * @param userId  ID del usuario a actualizar.
     * @param usuario Datos actualizados del usuario.
     * @return Usuario actualizado.
     */
    @WebMethod(operationName = "updateUser")
    @WebResult(name = "user")
    Usuario updateUser(
            @WebParam(name = "userId") int userId,
            @WebParam(name = "usuario") Usuario usuario
    );

    /**
     * Elimina un usuario por su ID.
     *
     * @param userId ID del usuario a eliminar.
     * @return `true` si la eliminación fue exitosa.
     */
    @WebMethod(operationName = "deleteUser")
    @WebResult(name = "success")
    boolean deleteUser(@WebParam(name = "userId") int userId);
}
