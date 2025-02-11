package es.system.danileonpe.springboot.repository;

import es.system.danileonpe.springboot.model.Coleccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColeccionRepository extends JpaRepository<Coleccion, Integer> {
}
