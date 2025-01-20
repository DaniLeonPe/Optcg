package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Coleccion;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

/**
 * Interfaz SOAP para la gestión de colecciones.
 */
@WebService(targetNamespace = "http://springboot.soap.service")
public interface ColeccionServiceSoapInterface {

    @WebMethod
    @WebResult(name = "coleccion")
    List<Coleccion> getAllColecciones();

    @WebMethod
    @WebResult(name = "coleccion")
    Coleccion getColeccionById(@WebParam(name = "coleccionId") int coleccionId) throws ResourceNotFoundException;

    @WebMethod
    @WebResult(name = "coleccion")
    Coleccion addColeccion(@WebParam(name = "coleccion") Coleccion coleccion);

    @WebMethod
    @WebResult(name = "coleccion")
    Coleccion updateColeccion(
            @WebParam(name = "coleccionId") int coleccionId,
            @WebParam(name = "coleccion") Coleccion coleccion
    ) throws ResourceNotFoundException;

    @WebMethod
    boolean deleteColeccion(@WebParam(name = "coleccionId") int coleccionId) throws ResourceNotFoundException;
}
