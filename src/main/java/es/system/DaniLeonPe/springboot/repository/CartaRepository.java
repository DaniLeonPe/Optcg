package es.system.danileonpe.springboot.repository;

import es.system.danileonpe.springboot.model.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Integer> {
}
