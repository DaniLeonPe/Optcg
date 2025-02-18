package es.ies.puerto.optcg.project.service.rest.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.ies.puerto.optcg.project.model.entities.Expansion;
import es.ies.puerto.optcg.project.repository.jpa.dao.ExpansionRepository;
import es.ies.puerto.optcg.project.service.interfaces.IService;



/**
 * Servicio para la gestión de expansiones.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Expansion.
 */
@Component

public class ExpansionService implements IService<Expansion> {



    private ExpansionRepository repository;

    public ExpansionService(){}

    @Autowired
    public void setRepository(ExpansionRepository repository){
        this.repository=repository;
    }
     /** 
     * @param t
     * @return boolean
     */
    @Override
    public boolean add(Expansion t) {
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
    public boolean update(int id, Expansion t) throws Exception {
        try{
            Expansion update = repository.findById(id).orElse(null);
            if(update != null){
               update.setNombre(t.getNombre());
               update.setFechaLanzamiento(t.getFechaLanzamiento());
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
    public List<Expansion> getAll() {
        return repository.findAll();
    }

    
    /** 
     * @param id
     * @return Carta
     */
    @Override
    public Expansion getById(int id) {
        return repository.findById(id).orElse(null);
    }

    
    /** 
     * @param id
     * @return boolean
     */
    @Override
    public boolean delete(int id) {
        Expansion expansion = repository.findById(id).orElse(null);
        if(expansion != null){
            repository.delete(expansion);
            return true;
        }else{
            return false;
        }
    }

}