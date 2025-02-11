package es.system.danileonpe.springboot.service.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.model.Coleccion;
import es.system.danileonpe.springboot.model.ColeccionCarta;
import es.system.danileonpe.springboot.repository.CartaRepository;
import es.system.danileonpe.springboot.repository.ColeccionCartaRepository;
import es.system.danileonpe.springboot.repository.ColeccionRepository;

@Service
public class ColeccionCartaService {

    @Autowired
    public
    CartaRepository cartaRepository;

    @Autowired
    public
    ColeccionRepository coleccionRepository;

    @Autowired
    ColeccionCartaRepository repository;
    

    // Obtener cartas de una coleccion especifica
    public List<Carta> getCartasbyColeccion(int coleccionId) {
        Coleccion coleccion = coleccionRepository.findById(coleccionId).orElse(null);
        List<ColeccionCarta> coleccionCartas = repository.findByColeccion(coleccion);
       return coleccionCartas.stream()
                .map(ColeccionCarta::getCarta)
                .collect(Collectors.toList());
    }

    // Obtener colecciones que contienen una carta especifica

    public List<Coleccion> getColeccionesByCarta(int cartaid) {
        Carta carta = cartaRepository.findById(cartaid).orElse(null);
        return repository.findByCarta(carta);
    }

    // Agregar una carta a una coleccion
    public ColeccionCarta addCarta(Coleccion coleccion, Carta carta, int cantidad) {
        ColeccionCarta coleccionCarta = new ColeccionCarta();
        coleccionCarta.setCarta(carta);
        coleccionCarta.setColeccion(coleccion);
        coleccionCarta.setCantidad(cantidad);
        return repository.save(coleccionCarta);
    }

    // Eliminar una carta de una coleccion
    public boolean deleteCarta(Coleccion coleccion, Carta carta) {
        ColeccionCarta coleccionCarta = repository.findByCartaAndColeccion(carta, coleccion);
        if (coleccionCarta != null) {
            repository.delete(coleccionCarta);
            return true;
        }
        return false;
    }


}
