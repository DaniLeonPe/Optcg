package es.system.danileonpe.springboot.repository;

import es.system.danileonpe.springboot.model.Carta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaRepository extends JpaRepository<Carta, Integer> {
}
