package es.system.danileonpe.springboot.service.rest;


import java.util.List;

import es.system.danileonpe.springboot.model.Mazo;
import es.system.danileonpe.springboot.repository.MazoRepository;
import es.system.danileonpe.springboot.service.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Servicio para la gestión de mazos.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Mazo.
 */
@Component
public class MazoService implements IService<Mazo>{


    @Autowired
    MazoRepository repository;

   

     /** 
     * @param t
     * @return boolean
     */
    @Override
    public boolean add(Mazo t) {
        if(t == null){
            return false;
        }
        if(repository.existsById(t.getIdMazo())){
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
    public boolean update(int id, Mazo t) throws Exception {
        try{
            Mazo update = repository.findById(id).orElse(null);
            if(update != null){
               update.setNombre(t.getNombre());
               update.setDescripcion(t.getDescripcion());
               update.setUsuario(t.getUsuario());
               update.setFechaCreacion(t.getFechaCreacion());
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
    public List<Mazo> getAll() {
        return repository.findAll();
    }

    
    /** 
     * @param id
     * @return Carta
     */
    @Override
    public Mazo getById(int id) {
        return repository.findById(id).orElse(null);
    }

    
    /** 
     * @param id
     * @return boolean
     */
    @Override
    public boolean delete(int id) {
        Mazo mazo = repository.findById(id).orElse(null);
        if(mazo != null){
            repository.delete(mazo);
            return true;
        }else{
            return false;
        }
    }
   

}