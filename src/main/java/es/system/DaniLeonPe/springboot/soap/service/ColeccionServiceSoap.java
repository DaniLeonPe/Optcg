package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.service.ColeccionServiceInterface;
import es.system.danileonpe.springboot.model.Coleccion;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(endpointInterface = "es.system.danileonpe.springboot.soap.service.ColeccionServiceSoapInterface")
public class ColeccionServiceSoap implements ColeccionServiceSoapInterface {

    @Autowired
    private ColeccionServiceInterface coleccionService;

    @Override
    public List<Coleccion> getAllColecciones() {
        return coleccionService.getAllColeccion();
    }

    @Override
    public Coleccion getColeccionById(int coleccionId) throws ResourceNotFoundException {
        return coleccionService.getColeccionById(coleccionId);
    }

    @Override
    public Coleccion addColeccion(Coleccion coleccion) {
        return coleccionService.createColeccion(coleccion);
    }

    @Override
    public Coleccion updateColeccion(int coleccionId, Coleccion coleccion) throws ResourceNotFoundException {
        return coleccionService.updateColeccion(coleccionId, coleccion);
    }

    @Override
    public boolean deleteColeccion(int coleccionId) throws ResourceNotFoundException {
        return coleccionService.deleteColeccion(coleccionId);
    }
}
