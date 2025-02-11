package es.system.danileonpe.springboot.service.rest;

import java.util.List;

import es.system.danileonpe.springboot.repository.RolRepository;
import es.system.danileonpe.springboot.service.interfaces.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.system.danileonpe.springboot.model.Rol;


/**
 * Servicio para la gestión de roles.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Rol.
 */
@Component

public class RolService implements IService<Rol> {

    @Autowired
    RolRepository repository;

     /** 
     * @param t
     * @return boolean
     */
    @Override
    public boolean add(Rol t) {
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
    public boolean update(int id, Rol t) throws Exception {
        try{
            Rol update = repository.findById(id).orElse(null);
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
    public List<Rol> getAll() {
        return repository.findAll();
    }

    
    /** 
     * @param id
     * @return Carta
     */
    @Override
    public Rol getById(int id) {
        return repository.findById(id).orElse(null);
    }

    
    /** 
     * @param id
     * @return boolean
     */
    @Override
    public boolean delete(int id) {
        Rol rol = repository.findById(id).orElse(null);
        if(rol != null){
            repository.delete(rol);
            return true;
        }else{
            return false;
        }
    }


   
}
