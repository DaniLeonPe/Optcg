package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Rol;
import es.system.danileonpe.springboot.service.RolServiceInterface;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementación SOAP para la gestión de roles.
 */
@Component
@WebService(endpointInterface = "es.system.danileonpe.springboot.soap.service.RolServiceSoapInterface")
public class RolServiceSoap implements RolServiceSoapInterface {

    @Autowired
    private RolServiceInterface rolService;

    @Override
    public List<Rol> getAllRoles() {
        return rolService.getAllRols();
    }

    @Override
    public Rol getRolById(int rolId) throws ResourceNotFoundException {
        return rolService.getRolById(rolId);
    }

    @Override
    public Rol addRol(Rol rol) {
        return rolService.createRol(rol);
    }

    @Override
    public Rol updateRol(int rolId, Rol rol) throws ResourceNotFoundException {
        return rolService.updateRol(rolId, rol);
    }

    @Override
    public boolean deleteRol(int rolId) throws ResourceNotFoundException {
        return rolService.deleteRol(rolId);
    }
}
