package es.system.danileonpe.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.model.Coleccion;
import es.system.danileonpe.springboot.model.ColeccionCarta;

@Repository
public interface ColeccionCartaRepository extends JpaRepository<ColeccionCarta, Integer> {
    

    // Buscar por carta y colección
    ColeccionCarta findByCartaAndColeccion(Carta carta, Coleccion coleccion);

    // Buscar por colección
    List<ColeccionCarta> findByColeccion(Coleccion coleccion);

    // Buscar por carta
    List<Coleccion> findByCarta(Carta carta);


}
