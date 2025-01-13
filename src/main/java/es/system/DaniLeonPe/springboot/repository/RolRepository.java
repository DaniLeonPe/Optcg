package es.system.DaniLeonPe.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.system.DaniLeonPe.springboot.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    
}
