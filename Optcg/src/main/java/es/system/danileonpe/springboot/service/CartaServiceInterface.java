package es.system.danileonpe.springboot.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Carta;

import java.util.List;

public interface CartaServiceInterface {
    List<Carta> getAllCartas();
    Carta getCartaById(int cartaId) throws ResourceNotFoundException;
    public Carta createCarta(Carta carta);
    Carta updateCarta(int cartaId, Carta cartaDetails)       throws ResourceNotFoundException;
    boolean deleteCarta(int cartaId) throws ResourceNotFoundException;
}
