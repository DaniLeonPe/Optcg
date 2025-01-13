package es.system.DaniLeonPe.springboot.repository;

import es.system.DaniLeonPe.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
