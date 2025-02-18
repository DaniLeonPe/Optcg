package es.ies.puerto.optcg.project.service.soap.impl;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.ies.puerto.optcg.project.dto.CartaDTO;
import es.ies.puerto.optcg.project.dto.MazoCartaDTO;
import es.ies.puerto.optcg.project.dto.MazoDTO;
import es.ies.puerto.optcg.project.mapper.struct.CartaMapper;
import es.ies.puerto.optcg.project.mapper.struct.MazoMapper;
import es.ies.puerto.optcg.project.model.entities.Carta;
import es.ies.puerto.optcg.project.model.entities.Mazo;
import es.ies.puerto.optcg.project.model.entities.MazoCarta;
import es.ies.puerto.optcg.project.service.rest.impl.MazoCartaService;

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
        return null;
       // return new MazoCartaDTO(mazoCarta.getId(), mazoCarta.getMazo().getId(), mazoCarta.getCarta().getId(), mazoCarta.getCantidad());
    }

    @WebMethod
    public boolean deleteCartaFromMazo(int mazoId, int cartaId) {
        Mazo mazo = mazoCartaService.mazoRepository.findById(mazoId).orElse(null);
        Carta carta = mazoCartaService.cartaRepository.findById(cartaId).orElse(null);
        return mazoCartaService.deleteCartaFromMazo(mazo, carta);
    }
}

