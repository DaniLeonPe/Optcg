package es.system.danileonpe.springboot.soap.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.system.danileonpe.springboot.DTO.CartaDTO;
import es.system.danileonpe.springboot.DTO.ColeccionCartaDTO;
import es.system.danileonpe.springboot.DTO.ColeccionDTO;
import es.system.danileonpe.springboot.mapper.CartaMapper;
import es.system.danileonpe.springboot.mapper.ColeccionMapper;
import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.model.Coleccion;
import es.system.danileonpe.springboot.model.ColeccionCarta;
import es.system.danileonpe.springboot.service.rest.ColeccionCartaService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@Component
@WebService
public class ColeccionCartaServiceSoap {
    @Autowired
    private ColeccionCartaService cartaService;
    
    @WebMethod
    public List<CartaDTO> getCartasbyColeccion(int coleccionId) {
        List<Carta> cartas = cartaService.getCartasbyColeccion(coleccionId);
        return cartas.stream()
                     .map(CartaMapper.INSTANCE::toDTO)
                     .collect(Collectors.toList());
    }

    @WebMethod
    public List<ColeccionDTO> getColeccionsByCarta(int cartaid) {
        List<Coleccion> colecciones = cartaService.getColeccionesByCarta(cartaid);
        return colecciones.stream()
                           .map(ColeccionMapper.INSTANCE::toDTO)
                           .collect(Collectors.toList());
    }

    @WebMethod
    public ColeccionCartaDTO addCarta(int coleccionId, int cartaId, int cantidad) {
        Coleccion coleccion = cartaService.coleccionRepository.findById(coleccionId).orElse(null);
        Carta carta = cartaService.cartaRepository.findById(cartaId).orElse(null);
        ColeccionCarta coleccionCarta = cartaService.addCarta(coleccion, carta, cantidad);
        return new ColeccionCartaDTO(coleccionCarta.getId(), coleccionCarta.getColeccion().getId(), coleccionCarta.getCarta().getId(), coleccionCarta.getCantidad());
    }

    @WebMethod
    public boolean deleteCarta(int coleccionId, int cartaId) {
        Coleccion coleccion = cartaService.coleccionRepository.findById(coleccionId).orElse(null);
        Carta carta = cartaService.cartaRepository.findById(cartaId).orElse(null);
        return cartaService.deleteCarta(coleccion, carta);
    }
}

