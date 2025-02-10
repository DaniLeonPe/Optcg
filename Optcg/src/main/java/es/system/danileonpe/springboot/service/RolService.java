package es.system.danileonpe.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Rol;
import es.system.danileonpe.springboot.repository.RolRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

/**
 * Servicio para la gestión de roles.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Rol.
 */
@Component

public class RolService implements RolServiceInterface {

    private RolRepository rolRepository;


    /**
     * Inyección del repositorio de roles.
     *
     * @param rolRepository Repositorio de roles.
     */
    @Autowired
    public void setRolRepository(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }


    /**
     * Obtiene todos los roles almacenados.
     *
     * @return Lista de roles.
     */
    public List<Rol> getAllRols(){
        return rolRepository.findAll();
    }


    /**
     * Obtiene un rol por su ID.
     *
     * @param rolId Identificador del rol.
     * @return El rol encontrado.
     * @throws ResourceNotFoundException Si no se encuentra el rol con el ID proporcionado.
     */
    public Rol getRolById(@PathVariable(value = "id") int rolId) throws ResourceNotFoundException {
        return rolRepository.findById(rolId)
               .orElseThrow(() -> new ResourceNotFoundException("Rol not found for this id :: " + rolId));
    }


    /**
     * Crea un nuevo rol.
     *
     * @param rol Detalles del rol a crear.
     * @return El rol creado.
     */
    public Rol createRol(@Valid @RequestBody Rol rol){
        return rolRepository.save(rol);
    }


    /**
     * Actualiza un rol existente.
     *
     * @param rolId Identificador del rol a actualizar.
     * @param rolDetails Detalles actualizados del rol.
     * @return El rol actualizado.
     * @throws ResourceNotFoundException Si no se encuentra el rol con el ID proporcionado.
     */
    public Rol updateRol(@PathVariable(value = "id") int rolId,
     @Valid @RequestBody Rol rolDetails) throws ResourceNotFoundException {
        Rol rol = rolRepository.findById(rolId)
               .orElseThrow(() -> new ResourceNotFoundException("Rol not found for this id :: " + rolId));

        rol.setName(rolDetails.getName());
        return rolRepository.save(rol);
    }


    /**
     * Elimina un rol por su ID.
     *
     * @param rolId Identificador del rol a eliminar.
     * @return
     * @throws ResourceNotFoundException Si no se encuentra el rol con el ID proporcionado.
     */
    public boolean deleteRol(@PathVariable(value = "id") int rolId) throws ResourceNotFoundException {
        Rol rol = rolRepository.findById(rolId)
               .orElseThrow(() -> new ResourceNotFoundException("Rol not found for this id :: " + rolId));
        rolRepository.delete(rol);
        return false;
    }
}
