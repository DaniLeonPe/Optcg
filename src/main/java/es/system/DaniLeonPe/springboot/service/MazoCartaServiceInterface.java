package es.system.danileonpe.springboot.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.MazoCarta;

import java.util.List;

public interface MazoCartaServiceInterface {
    List<MazoCarta> getAllMazoCarta();
    MazoCarta getMazoCartaById(long mazoId, long cartaId) throws ResourceNotFoundException;
    MazoCarta createMazoCarta(MazoCarta mazoCarta);
    MazoCarta updateMazoCarta(long mazoId, long cartaId, MazoCarta mazoCartaDetails) throws ResourceNotFoundException;
    void deleteMazoCarta(long mazoId, long cartaId) throws ResourceNotFoundException;
}

