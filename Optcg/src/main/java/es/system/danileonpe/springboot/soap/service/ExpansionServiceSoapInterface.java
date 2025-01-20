package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Expansion;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

/**
 * Interfaz SOAP para la gestión de expansiones.
 */
@WebService(targetNamespace = "http://springboot.soap.service")
public interface ExpansionServiceSoapInterface {

    @WebMethod
    @WebResult(name = "expansion")
    List<Expansion> getAllExpansions();

    @WebMethod
    @WebResult(name = "expansion")
    Expansion getExpansionById(@WebParam(name = "expansionId") int expansionId) throws ResourceNotFoundException;

    @WebMethod
    @WebResult(name = "expansion")
    Expansion addExpansion(@WebParam(name = "expansion") Expansion expansion);

    @WebMethod
    @WebResult(name = "expansion")
    Expansion updateExpansion(
            @WebParam(name = "expansionId") int expansionId,
            @WebParam(name = "expansion") Expansion expansion
    ) throws ResourceNotFoundException;

    @WebMethod
    boolean deleteExpansion(@WebParam(name = "expansionId") int expansionId) throws ResourceNotFoundException;
}
