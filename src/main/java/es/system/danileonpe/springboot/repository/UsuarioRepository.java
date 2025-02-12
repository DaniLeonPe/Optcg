package es.system.danileonpe.springboot.repository;

import es.system.danileonpe.springboot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Usuario findByName(String name);

    Usuario findByEmail(String email);
}
