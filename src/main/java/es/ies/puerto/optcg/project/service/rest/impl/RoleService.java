package es.ies.puerto.optcg.project.service.rest.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.ies.puerto.optcg.project.model.entities.Role;
import es.ies.puerto.optcg.project.repository.jpa.dao.IDaoRole;
import es.ies.puerto.optcg.project.service.interfaces.IService;



/**
 * Servicio para la gestión de roles.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Rol.
 */
@Component
@Transactional
public class RoleService implements IService<Role> {
    private final static Logger LOGGER = LoggerFactory.getLogger(RoleService.class);

    private IDaoRole repository;

    /**
     * Default constructor of the class
     */
    public RoleService(){}


    /**
     * Setter of the dao
     * @param repository of the service
     */
    @Autowired
    public void setDao(IDaoRole repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(Role role) {
        if (role == null){
            return false;
        }
        if(repository.existsById(role.getId())){
            return false;
        }

        repository.save(role);
        return true;
    }

    @Override
    public boolean update(int id, Role role) throws Exception {
        try {
            Role toUpdate = repository.findById(id).orElse(null);

            if(toUpdate!= null){
                toUpdate.setName(role.getName());
                repository.save(toUpdate);
                return true;
            } else {
                return false;
            }

        } catch (RuntimeException e){
            return false;
        }
    }


    @Override
    public List<Role> getAll() {
        return repository.findAll();
    }

    @Override
    public Role getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(int id) {
        if(id == 1){
            return false;
        }

        int quantity = repository.deleteItemById(id);
        return quantity > 0;
    }
}