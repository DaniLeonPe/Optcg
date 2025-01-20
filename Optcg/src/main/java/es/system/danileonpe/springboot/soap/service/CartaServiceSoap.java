package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.service.CartaServiceInterface;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(endpointInterface = "es.system.danileonpe.springboot.soap.service.CartaServiceSoapInterface")
public class CartaServiceSoap implements CartaServiceSoapInterface {

    @Autowired
    private CartaServiceInterface cartaService;

    @Override
    public List<Carta> getAllCartas() {
        return cartaService.getAllCartas();
    }

    @Override
    public Carta getCartaById(int cartaId) throws ResourceNotFoundException {
        return cartaService.getCartaById(cartaId);
    }

    @Override
    public Carta addCarta(Carta carta) {
        return cartaService.createCarta(carta);
    }

    @Override
    public Carta updateCarta(int cartaId, Carta carta) throws ResourceNotFoundException {
        return cartaService.updateCarta(cartaId, carta);
    }

    @Override
    public boolean deleteCarta(int cartaId) throws ResourceNotFoundException {
        return cartaService.deleteCarta(cartaId);
    }
}
