package es.system.danileonpe.springboot.service.rest;


import java.util.List;
import es.system.danileonpe.springboot.model.Coleccion;
import es.system.danileonpe.springboot.repository.ColeccionRepository;
import es.system.danileonpe.springboot.service.interfaces.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * Servicio para la gestión de coleccion.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Coleccion.
 */
@Component
public class ColeccionService implements IService<Coleccion>{

    @Autowired
    ColeccionRepository repository;

    /** 
     * @param t
     * @return boolean
     */
    @Override
    public boolean add(Coleccion t) {
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
    public boolean update(int id, Coleccion t) throws Exception {
        try{
            Coleccion update = repository.findById(id).orElse(null);
            if(update != null){
                update.setCantidad(t.getCantidad());
                update.setCarta(t.getCarta());
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
    public List<Coleccion> getAll() {
        return repository.findAll();
    }

    
    /** 
     * @param id
     * @return Carta
     */
    @Override
    public Coleccion getById(int id) {
        return repository.findById(id).orElse(null);
    }

    
    /** 
     * @param id
     * @return boolean
     */
    @Override
    public boolean delete(int id) {
        Coleccion coleccion = repository.findById(id).orElse(null);
        if(coleccion != null){
            repository.delete(coleccion);
            return true;
        }else{
            return false;
        }
    }
   

}