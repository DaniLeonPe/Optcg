package es.system.danileonpe.springboot.repository;

import es.system.danileonpe.springboot.model.Mazo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MazoRepository extends JpaRepository<Mazo, Integer> {
}
