package es.system.DaniLeonPe.springboot.service;

import java.util.List;

import es.system.DaniLeonPe.springboot.exception.ResourceNotFoundException;
import es.system.DaniLeonPe.springboot.model.Rol;

public interface RolServiceInterface {
    List<Rol> getAllRols();
    Rol getRolById(int rolId) throws ResourceNotFoundException;
    public Rol createRol(Rol rol);
    Rol updateRol(int rolId, Rol rolDetails)       throws ResourceNotFoundException;
    void deleteRol(int rolId) throws ResourceNotFoundException;
}
