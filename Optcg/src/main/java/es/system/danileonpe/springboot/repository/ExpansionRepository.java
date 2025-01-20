package es.system.danileonpe.springboot.repository;

import es.system.danileonpe.springboot.model.Expansion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpansionRepository extends JpaRepository<Expansion, Integer> {
}
