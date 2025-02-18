package es.ies.puerto.optcg.project.repository.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.ies.puerto.optcg.project.model.entities.Role;



@Repository
public interface IDaoRole extends JpaRepository<Role, Integer> {
    @Modifying
    @Query("DELETE FROM Role r WHERE r.id=:id")
    int deleteItemById(@Param("id") Integer id);
}
