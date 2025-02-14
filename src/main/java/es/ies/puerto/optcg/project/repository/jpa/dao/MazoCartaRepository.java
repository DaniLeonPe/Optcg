package es.ies.puerto.optcg.project.repository.jpa.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ies.puerto.optcg.project.model.entities.Carta;
import es.ies.puerto.optcg.project.model.entities.Mazo;
import es.ies.puerto.optcg.project.model.entities.MazoCarta;

@Repository
public interface MazoCartaRepository extends JpaRepository<MazoCarta, Integer> {

    //Buscar cartas por mazo
    List<MazoCarta> findByMazo(Mazo mazo);

    //Buscar mazos por carta
    List<Mazo> findByCarta(Carta carta);

    //Buscar mazoCarta por carta y mazo
    MazoCarta findByCartaAndMazo(Carta carta, Mazo mazo);


}
