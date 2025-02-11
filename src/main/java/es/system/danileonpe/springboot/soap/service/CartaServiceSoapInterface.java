package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Carta;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

/**
 * Interfaz SOAP para la gestión de cartas.
 */
@WebService(targetNamespace = "http://springboot.soap.service")
public interface CartaServiceSoapInterface {

    @WebMethod
    @WebResult(name = "carta")
    List<Carta> getAllCartas();

    @WebMethod
    @WebResult(name = "carta")
    Carta getCartaById(@WebParam(name = "cartaId") int cartaId) throws ResourceNotFoundException;

    @WebMethod
    @WebResult(name = "carta")
    Carta addCarta(@WebParam(name = "carta") Carta carta);

    @WebMethod
    @WebResult(name = "carta")
    Carta updateCarta(
            @WebParam(name = "cartaId") int cartaId,
            @WebParam(name = "carta") Carta carta
    ) throws ResourceNotFoundException;

    @WebMethod
    boolean deleteCarta(@WebParam(name = "cartaId") int cartaId) throws ResourceNotFoundException;
}
