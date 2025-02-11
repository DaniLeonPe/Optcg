package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Rol;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

/**
 * Interfaz SOAP para la gestión de roles.
 */
@WebService(targetNamespace = "http://springboot.soap.service")
public interface RolServiceSoapInterface {

    @WebMethod
    @WebResult(name = "rol")
    List<Rol> getAllRoles();

    @WebMethod
    @WebResult(name = "rol")
    Rol getRolById(@WebParam(name = "rolId") int rolId) throws ResourceNotFoundException;

    @WebMethod
    @WebResult(name = "rol")
    Rol addRol(@WebParam(name = "rol") Rol rol);

    @WebMethod
    @WebResult(name = "rol")
    Rol updateRol(
            @WebParam(name = "rolId") int rolId,
            @WebParam(name = "rol") Rol rol
    ) throws ResourceNotFoundException;

    @WebMethod
    boolean deleteRol(@WebParam(name = "rolId") int rolId) throws ResourceNotFoundException;
}
