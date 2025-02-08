package es.system.danileonpe.springboot.repository;

import es.system.danileonpe.springboot.model.MazoCarta;


import org.springframework.data.jpa.repository.JpaRepository;

public interface MazoCartaRepository extends JpaRepository<MazoCarta, Integer> {
}
