package es.ies.puerto.optcg.project.repository.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.ies.puerto.optcg.project.model.entities.User;

import java.util.Optional;

@Repository
public interface IDaoUser extends JpaRepository<User, Integer> {
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int deleteItemById(@Param("id") Integer id);

    @Query(
            value="SELECT * FROM users WHERE name=:name",
            nativeQuery=true
    )
    Optional<User> findUserByName(@Param("name") String name);


    @Query(
            value="SELECT * FROM users WHERE email=:email",
            nativeQuery=true
    )
    Optional<User> findUserByEmail(@Param("email") String email);
}
