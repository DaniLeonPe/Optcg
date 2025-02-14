package es.ies.puerto.optcg.project.repository.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ies.puerto.optcg.project.model.entities.Mazo;

@Repository
public interface MazoRepository extends JpaRepository<Mazo, Integer> {
}
