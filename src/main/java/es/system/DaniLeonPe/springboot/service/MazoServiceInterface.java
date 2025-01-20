package es.system.danileonpe.springboot.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Mazo;

import java.util.List;

public interface MazoServiceInterface {
    List<Mazo> getAllMazo();
    Mazo getMazoById(int mazoId) throws ResourceNotFoundException;
    public Mazo createMazo(Mazo mazoId);
    Mazo updateMazo(int mazoId, Mazo mazoDetails)       throws ResourceNotFoundException;
    boolean deleteMazo(int mazoId) throws ResourceNotFoundException;
}
