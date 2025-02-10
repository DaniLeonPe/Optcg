package es.system.danileonpe.springboot.service.rest;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.model.Mazo;
import es.system.danileonpe.springboot.model.MazoCarta;
import es.system.danileonpe.springboot.repository.CartaRepository;
import es.system.danileonpe.springboot.repository.MazoCartaRepository;
import es.system.danileonpe.springboot.repository.MazoRepository;

/**
 * Servicio para la gestión de mazosCartas.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad MazoCarta.
 */
@Component
public class MazoCartaService   {

    @Autowired
    public
    CartaRepository cartaRepository;

    @Autowired
    public
    MazoRepository mazoRepository;

    @Autowired
    MazoCartaRepository repository;


    // Obtener cartas de un mazo específico
    public List<Carta> getCartasByMazo(int mazoId) {
        Mazo mazo = mazoRepository.findById(mazoId).orElse(null);
        List<MazoCarta> mazoCartas = repository.findByMazo(mazo);
        return mazoCartas.stream()
                .map(MazoCarta::getCarta)
                .collect(Collectors.toList());
    }


    // Obtener mazos que contienen una carta especifica
    public List<Mazo> getMazosByCarta(int cartaId) {
        Carta carta = cartaRepository.findById(cartaId).orElse(null);
        return repository.findByCarta(carta);
    }



    //Agregar carta al mazo
    public MazoCarta addCartaToMazo(Mazo mazo, Carta carta, int cantidad){
        MazoCarta mazoCarta = new MazoCarta();
        mazoCarta.setMazo(mazo);
        mazoCarta.setCarta(carta);
        mazoCarta.setCantidad(cantidad);
        return repository.save(mazoCarta);
    }

    //Eliminar carta del mazo
    public boolean deleteCartaFromMazo(Mazo mazo, Carta carta){
        MazoCarta mazoCarta = repository.findByCartaAndMazo(carta, mazo);
        if(mazoCarta != null){
            repository.delete(mazoCarta);
            return true;
        }
        return false;
    }
   
}
