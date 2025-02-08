package es.system.danileonpe.springboot.service.rest;

import java.util.List;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Rol;
import es.system.danileonpe.springboot.model.Usuario;
import es.system.danileonpe.springboot.repository.UsuarioRepository;
import es.system.danileonpe.springboot.service.interfaces.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

/**
 * Servicio para la gestión de usuarios.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Usuario.
 */
@Component
public class UserService implements IService<Usuario>{

    @Autowired
    UsuarioRepository repository;

      /** 
     * @param t
     * @return boolean
     */
    @Override
    public boolean add(Usuario t) {
        if(t == null){
            return false;
        }
        if(repository.existsById(t.getIdUsuario())){
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
    public boolean update(int id, Usuario t) throws Exception {
        try{
            Usuario update = repository.findById(id).orElse(null);
            if(update != null){
               update.setNombreUsuario(t.getNombreUsuario());
               update.setContraseña(t.getContraseña());
               update.setRol(t.getRol());
               update.setEmail(t.getEmail());
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
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    
    /** 
     * @param id
     * @return Carta
     */
    @Override
    public Usuario getById(int id) {
        return repository.findById(id).orElse(null);
    }

    
    /** 
     * @param id
     * @return boolean
     */
    @Override
    public boolean delete(int id) {
        Usuario usuario = repository.findById(id).orElse(null);
        if(usuario != null){
            repository.delete(usuario);
            return true;
        }else{
            return false;
        }
    }

    
}
