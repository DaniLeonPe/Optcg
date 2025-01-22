package es.system.danileonpe.springboot.service;

import java.util.List;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Expansion;
import es.system.danileonpe.springboot.repository.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;


/**
 * Servicio para la gestión de expansiones.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Expansion.
 */
@Component

public class ExpansionService implements ExpansionServiceInterface {

    private ExpansionRepository expansionRepository;


    /**
     * Inyección del repositorio de expansion.
     *
     * @param expansionRepository Repositorio de expansion.
     */
    @Autowired
    public void setExpansionRepository(ExpansionRepository expansionRepository) {
        this.expansionRepository = expansionRepository;
    }


    /**
     * Obtiene todos los expansiones almacenados.
     *
     * @return Lista de expansiones.
     */
    public List<Expansion> getAllExpansion(){
        return expansionRepository.findAll();
    }



    /**
     * Obtiene un expansion por su ID.
     *
     * @param expansionId Identificador del expansion.
     * @return El expansion encontrado.
     * @throws ResourceNotFoundException Si no se encuentra el expansion con el ID proporcionado.
     */
    public Expansion getExpansionById(@PathVariable(value = "id") int expansionId) throws ResourceNotFoundException {
        return expansionRepository.findById(expansionId)
                .orElseThrow(() -> new ResourceNotFoundException("Rol not found for this id :: " + expansionId));
    }


    /**
     * Crea una nueva expansion.
     *
     * @param expansion Detalles del expansion a crear.
     * @return El expansion creado.
     */
    public Expansion createExpansion(@Valid @RequestBody Expansion expansion){
        return expansionRepository.save(expansion);
    }


    /**
     * Actualiza un expansion existente.
     *
     * @param expansionId Identificador del expansion a actualizar.
     * @param expansionDetails Detalles actualizados del expansion.
     * @return El expansion actualizado.
     * @throws ResourceNotFoundException Si no se encuentra el expansion con el ID proporcionado.
     */
    public Expansion updateExpansion(@PathVariable(value = "id") int expansionId,
                         @Valid @RequestBody Expansion expansionDetails) throws ResourceNotFoundException {
        Expansion expansion = expansionRepository.findById(expansionId)
                .orElseThrow(() -> new ResourceNotFoundException("Expansion not found for this id :: " + expansionId));

        expansion.setNombre(expansionDetails.getNombre());
        return expansionRepository.save(expansion);
    }


    /**
     * Elimina un expansion por su ID.
     *
     * @param expansionId Identificador del expansion a eliminar.
     * @return
     * @throws ResourceNotFoundException Si no se encuentra el expansion con el ID proporcionado.
     */
    public boolean deleteExpansion(@PathVariable(value = "id") int expansionId) throws ResourceNotFoundException {
        Expansion expansion = expansionRepository.findById(expansionId)
                .orElseThrow(() -> new ResourceNotFoundException("Expansion not found for this id :: " + expansionId));
        expansionRepository.delete(expansion);
        return false;
    }
}