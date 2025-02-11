package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Mazo;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

/**
 * Interfaz SOAP para la gestión de mazos.
 */
@WebService(targetNamespace = "http://springboot.soap.service")
public interface MazoServiceSoapInterface {

    @WebMethod
    @WebResult(name = "mazo")
    List<Mazo> getAllMazos();

    @WebMethod
    @WebResult(name = "mazo")
    Mazo getMazoById(@WebParam(name = "mazoId") int mazoId) throws ResourceNotFoundException;

    @WebMethod
    @WebResult(name = "mazo")
    Mazo addMazo(@WebParam(name = "mazo") Mazo mazo);

    @WebMethod
    @WebResult(name = "mazo")
    Mazo updateMazo(
            @WebParam(name = "mazoId") int mazoId,
            @WebParam(name = "mazo") Mazo mazo
    ) throws ResourceNotFoundException;

    @WebMethod
    boolean deleteMazo(@WebParam(name = "mazoId") int mazoId) throws ResourceNotFoundException;
}
