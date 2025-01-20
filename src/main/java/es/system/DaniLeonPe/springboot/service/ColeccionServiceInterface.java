package es.system.danileonpe.springboot.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;

import es.system.danileonpe.springboot.model.Coleccion;

import java.util.List;

public interface ColeccionServiceInterface {
    List<Coleccion> getAllColeccion();
    Coleccion getColeccionById(int coleccionId) throws ResourceNotFoundException;
    public Coleccion createColeccion(Coleccion coleccion);
    Coleccion updateColeccion(int coleccionId, Coleccion coleccionDetails)       throws ResourceNotFoundException;
    boolean deleteColeccion(int coleccionId) throws ResourceNotFoundException;
}
