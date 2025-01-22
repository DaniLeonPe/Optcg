package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.MazoCarta;
import es.system.danileonpe.springboot.service.MazoCartaServiceInterface;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementación SOAP para la gestión de mazo-carta.
 */
@Component
@WebService(endpointInterface = "es.system.danileonpe.springboot.soap.service.MazoCartaServiceSoapInterface")
public class MazoCartaServiceSoap implements MazoCartaServiceSoapInterface {

    @Autowired
    private MazoCartaServiceInterface mazoCartaService;

    @Override
    public List<MazoCarta> getAllMazoCarta() {
        try {
            return mazoCartaService.getAllMazoCarta();
        } catch (Exception e) {
            throw new WebServiceException("Error al obtener todas las asociaciones mazo-carta", e);
        }
    }

    @Override
    public MazoCarta getMazoCartaById(long mazoId, long cartaId) {
        try {
            return mazoCartaService.getMazoCartaById(mazoId, cartaId);
        } catch (ResourceNotFoundException e) {
            throw new WebServiceException("No se encontró la asociación mazo-carta", e);
        }
    }

    @Override
    public MazoCarta createMazoCarta(MazoCarta mazoCarta) {
        try {
            return mazoCartaService.createMazoCarta(mazoCarta);
        } catch (Exception e) {
            throw new WebServiceException("Error al crear la asociación mazo-carta", e);
        }
    }

    @Override
    public MazoCarta updateMazoCarta(long mazoId, long cartaId, MazoCarta mazoCartaDetails) {
        try {
            return mazoCartaService.updateMazoCarta(mazoId, cartaId, mazoCartaDetails);
        } catch (ResourceNotFoundException e) {
            throw new WebServiceException("No se encontró la asociación mazo-carta para actualizar", e);
        }
    }

    @Override
    public boolean deleteMazoCarta(long mazoId, long cartaId) {
        try {
            mazoCartaService.deleteMazoCarta(mazoId, cartaId);
            return true;
        } catch (ResourceNotFoundException e) {
            throw new WebServiceException("No se encontró la asociación mazo-carta para eliminar", e);
        }
    }
}
