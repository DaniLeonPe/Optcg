package es.system.danileonpe.springboot.service;

import java.util.List;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Rol;

public interface RolServiceInterface {
    List<Rol> getAllRols();
    Rol getRolById(int rolId) throws ResourceNotFoundException;
    public Rol createRol(Rol rol);
    Rol updateRol(int rolId, Rol rolDetails)       throws ResourceNotFoundException;
    boolean deleteRol(int rolId) throws ResourceNotFoundException;
}
