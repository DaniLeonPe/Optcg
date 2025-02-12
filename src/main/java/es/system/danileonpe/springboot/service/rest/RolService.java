package es.system.danileonpe.springboot.service.rest;

import java.util.List;

import es.system.danileonpe.springboot.model.Role;
import es.system.danileonpe.springboot.repository.RolRepository;
import es.system.danileonpe.springboot.service.interfaces.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * Servicio para la gestión de roles.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Rol.
 */
@Component

public class RolService implements IService<Role> {

    @Autowired
    RolRepository repository;

     /** 
     * @param t
     * @return boolean
     */
    @Override
    public boolean add(Role t) {
        if(t == null){
            return false;
        }
        if(repository.existsById(t.getId())){
            return false;
        }
        repository.save(t);
        return true;
    }

    
    /** 
     * @param id
     * @param t
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean update(int id, Role t) throws Exception {
        try{
            Role update = repository.findById(id).orElse(null);
            if(update != null){
               update.setName(t.getName());
                repository.save(update);
                return true;
            }else{
                return false;
            }
        }catch(RuntimeException e){
                return false;
            }
        
    
}

    
    /** 
     * @return List<Carta>
     */
    @Override
    public List<Role> getAll() {
        return repository.findAll();
    }

    
    /** 
     * @param id
     * @return Carta
     */
    @Override
    public Role getById(int id) {
        return repository.findById(id).orElse(null);
    }

    
    /** 
     * @param id
     * @return boolean
     */
    @Override
    public boolean delete(int id) {
        Role rol = repository.findById(id).orElse(null);
        if(rol != null){
            repository.delete(rol);
            return true;
        }else{
            return false;
        }
    }


   
}
