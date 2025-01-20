package es.system.danileonpe.springboot.repository;

import es.system.danileonpe.springboot.model.Mazo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MazoRepository extends JpaRepository<Mazo, Integer> {
}
