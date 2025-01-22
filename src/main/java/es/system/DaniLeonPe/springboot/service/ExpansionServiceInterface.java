package es.system.danileonpe.springboot.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Expansion;

import java.util.List;

public interface ExpansionServiceInterface {
    List<Expansion> getAllExpansion();
    Expansion getExpansionById(int expancionId) throws ResourceNotFoundException;
    public Expansion createExpansion(Expansion expancionId);
    Expansion updateExpansion(int expansionId, Expansion expancionDetails)       throws ResourceNotFoundException;
    boolean deleteExpansion(int expancionId) throws ResourceNotFoundException;
}
