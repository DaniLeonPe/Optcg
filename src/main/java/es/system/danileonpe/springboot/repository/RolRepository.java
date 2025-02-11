package es.system.danileonpe.springboot.repository;

import es.system.danileonpe.springboot.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    
}
