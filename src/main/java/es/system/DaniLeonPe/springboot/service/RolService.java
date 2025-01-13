package es.system.DaniLeonPe.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import es.system.DaniLeonPe.springboot.exception.ResourceNotFoundException;
import es.system.DaniLeonPe.springboot.model.Rol;
import es.system.DaniLeonPe.springboot.repository.RolRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@Component

public class RolService implements RolServiceInterface {

    private RolRepository rolRepository;

    @Autowired
    public void setRolRepository(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> getAllRols(){
        return rolRepository.findAll();
    }

    public Rol getRolById(@PathVariable(value = "id") int rolId) throws ResourceNotFoundException {
        return rolRepository.findById(rolId)
               .orElseThrow(() -> new ResourceNotFoundException("Rol not found for this id :: " + rolId));
    }
    
    public Rol createRol(@Valid @RequestBody Rol rol){
        return rolRepository.save(rol);
    }

    public Rol updateRol(@PathVariable(value = "id") int rolId,
     @Valid @RequestBody Rol rolDetails) throws ResourceNotFoundException {
        Rol rol = rolRepository.findById(rolId)
               .orElseThrow(() -> new ResourceNotFoundException("Rol not found for this id :: " + rolId));

        rol.setName(rolDetails.getName());
        return rolRepository.save(rol);
    }

    public void deleteRol(@PathVariable(value = "id") int rolId) throws ResourceNotFoundException {
        Rol rol = rolRepository.findById(rolId)
               .orElseThrow(() -> new ResourceNotFoundException("Rol not found for this id :: " + rolId));
        rolRepository.delete(rol);
    }
}
