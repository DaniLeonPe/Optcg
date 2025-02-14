package es.ies.puerto.optcg.project.repository.jpa.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ies.puerto.optcg.project.model.entities.Expansion;

@Repository
public interface ExpansionRepository extends JpaRepository<Expansion, Integer> {
}
