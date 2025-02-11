package es.system.danileonpe.springboot.repository;

import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.model.Mazo;
import es.system.danileonpe.springboot.model.MazoCarta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MazoCartaRepository extends JpaRepository<MazoCarta, Integer> {

    //Buscar cartas por mazo
    List<MazoCarta> findByMazo(Mazo mazo);

    //Buscar mazos por carta
    List<Mazo> findByCarta(Carta carta);

    //Buscar mazoCarta por carta y mazo
    MazoCarta findByCartaAndMazo(Carta carta, Mazo mazo);


}
