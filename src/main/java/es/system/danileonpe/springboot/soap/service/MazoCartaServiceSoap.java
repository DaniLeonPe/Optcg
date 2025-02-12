package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.DTO.CartaDTO;
import es.system.danileonpe.springboot.DTO.MazoCartaDTO;
import es.system.danileonpe.springboot.DTO.MazoDTO;
import es.system.danileonpe.springboot.mapper.CartaMapper;
import es.system.danileonpe.springboot.mapper.MazoMapper;
import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.model.Mazo;
import es.system.danileonpe.springboot.model.MazoCarta;
import es.system.danileonpe.springboot.service.rest.MazoCartaService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación SOAP para la gestión de mazo-carta.
 */
@Component
@WebService
public class MazoCartaServiceSoap {

    @Autowired
    private MazoCartaService mazoCartaService;

    @WebMethod
    public List<CartaDTO> getCartasByMazo(int mazoId) {
        List<Carta> cartas = mazoCartaService.getCartasByMazo(mazoId);
        return cartas.stream()
                .map(CartaMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @WebMethod
    public List<MazoDTO> getMazosByCarta(int cartaId) {
        List<Mazo> mazos = mazoCartaService.getMazosByCarta(cartaId);
        return mazos.stream()
                .map(MazoMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @WebMethod
    public MazoCartaDTO addCartaToMazo(int mazoId, int cartaId, int cantidad) {
        Mazo mazo = mazoCartaService.mazoRepository.findById(mazoId).orElse(null);
        Carta carta = mazoCartaService.cartaRepository.findById(cartaId).orElse(null);
        MazoCarta mazoCarta = mazoCartaService.addCartaToMazo(mazo, carta, cantidad);
        
        return new MazoCartaDTO(mazoCarta.getId(), mazoCarta.getMazo().getId(), mazoCarta.getCarta().getId(), mazoCarta.getCantidad());
    }

    @WebMethod
    public boolean deleteCartaFromMazo(int mazoId, int cartaId) {
        Mazo mazo = mazoCartaService.mazoRepository.findById(mazoId).orElse(null);
        Carta carta = mazoCartaService.cartaRepository.findById(cartaId).orElse(null);
        return mazoCartaService.deleteCartaFromMazo(mazo, carta);
    }
}

