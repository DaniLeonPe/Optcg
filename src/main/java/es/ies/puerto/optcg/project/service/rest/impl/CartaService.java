package es.ies.puerto.optcg.project.service.rest.impl;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.ies.puerto.optcg.project.model.entities.Carta;
import es.ies.puerto.optcg.project.repository.jpa.dao.CartaRepository;
import es.ies.puerto.optcg.project.service.interfaces.IService;



/**
 * Servicio para la gestión de Cartas.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Carta.
 */
@Component
public class CartaService implements IService<Carta>{

    @Autowired
    CartaRepository repository;

    
    /** 
     * @param t
     * @return boolean
     */
    @Override
    public boolean add(Carta t) {
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
    public boolean update(int id, Carta t) throws Exception {
        try{
            Carta cartaUpdate = repository.findById(id).orElse(null);
            if(cartaUpdate != null){
                cartaUpdate.setNombre(t.getNombre());
                cartaUpdate.setTipo(t.getTipo());
                cartaUpdate.setRareza(t.getRareza());
                cartaUpdate.setCosto(t.getCosto());
                cartaUpdate.setDescripcion(t.getDescripcion());
                cartaUpdate.setExpansion(t.getExpansion());
                cartaUpdate.setImagenUrl(t.getImagenUrl());
                repository.save(cartaUpdate);
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
    public List<Carta> getAll() {
        return repository.findAll();
    }

    
    /** 
     * @param id
     * @return Carta
     */
    @Override
    public Carta getById(int id) {
        return repository.findById(id).orElse(null);
    }

    
    /** 
     * @param id
     * @return boolean
     */
    @Override
    public boolean delete(int id) {
        Carta carta = repository.findById(id).orElse(null);
        if(carta != null){
            repository.delete(carta);
            return true;
        }else{
            return false;
        }
    }


   
}