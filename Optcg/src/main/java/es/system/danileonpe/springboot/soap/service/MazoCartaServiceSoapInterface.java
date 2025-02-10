package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.model.MazoCarta;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

/**
 * Interfaz SOAP para la gestión de mazo-carta.
 */
@WebService(targetNamespace = "http://springboot.soap.service")
public interface MazoCartaServiceSoapInterface {

    @WebMethod
    @WebResult(name = "mazoCarta")
    List<MazoCarta> getAllMazoCarta();

    @WebMethod
    @WebResult(name = "mazoCarta")
    MazoCarta getMazoCartaById(
            @WebParam(name = "mazoId") long mazoId,
            @WebParam(name = "cartaId") long cartaId
    );

    @WebMethod
    @WebResult(name = "mazoCarta")
    MazoCarta createMazoCarta(@WebParam(name = "mazoCarta") MazoCarta mazoCarta);

    @WebMethod
    @WebResult(name = "mazoCarta")
    MazoCarta updateMazoCarta(
            @WebParam(name = "mazoId") long mazoId,
            @WebParam(name = "cartaId") long cartaId,
            @WebParam(name = "mazoCarta") MazoCarta mazoCartaDetails
    );

    @WebMethod
    boolean deleteMazoCarta(
            @WebParam(name = "mazoId") long mazoId,
            @WebParam(name = "cartaId") long cartaId
    );
}
