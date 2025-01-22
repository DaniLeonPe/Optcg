package es.system.danileonpe.springboot.service;


import java.util.List;

import es.system.danileonpe.springboot.model.Mazo;
import es.system.danileonpe.springboot.repository.MazoRepository;
import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

/**
 * Servicio para la gestión de mazos.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Mazo.
 */
@Component
public class MazoService implements MazoServiceInterface{

    private MazoRepository mazoRepository;

    /**
     * Inyección del repositorio de mazos.
     *
     * @param mazoRepository Repositorio de mazos.
     */
    @Autowired
    public void setMazoRepository(MazoRepository mazoRepository) {
        this.mazoRepository = mazoRepository;
    }


    /**
     * Obtiene todos los mazos almacenados.
     *
     * @return Lista de mazos.
     */
    public List<Mazo> getAllMazo() {
        return mazoRepository.findAll();
    }


    /**
     * Obtiene un mazo por su ID.
     *
     * @param mazoId Identificador del rol.
     * @return El mazo encontrado.
     * @throws ResourceNotFoundException Si no se encuentra el mazo con el ID proporcionado.
     */
    public Mazo getMazoById(@PathVariable(value = "id") int mazoId) throws ResourceNotFoundException {
        return mazoRepository.findById(mazoId)
                .orElseThrow(() -> new ResourceNotFoundException("Mazo not found for this id :: " + mazoId));
    }


    /**
     * Crea un nuevo mazo.
     *
     * @param mazo Detalles del mazo a crear.
     * @return El mazo creado.
     */
    public Mazo createMazo(@Valid @RequestBody Mazo mazo) {
        return mazoRepository.save(mazo);
    }


    /**
     * Actualiza un mazo existente.
     *
     * @param mazoId Identificador del mazo a actualizar.
     * @param mazoDetails Detalles actualizados del mazo.
     * @return El mazo actualizado.
     * @throws ResourceNotFoundException Si no se encuentra el mazo con el ID proporcionado.
     */
    public Mazo updateMazo(@PathVariable(value = "id") int mazoId,
                             @Valid @RequestBody Mazo mazoDetails) throws ResourceNotFoundException {
        Mazo mazo = mazoRepository.findById(mazoId)
                .orElseThrow(() -> new ResourceNotFoundException("Mazo not found for this id :: " + mazoId));

        mazo.setNombre(mazoDetails.getNombre());
        return mazoRepository.save(mazo);
    }


    /**
     * Elimina un mazo por su ID.
     *
     * @param mazoId Identificador del mazo a eliminar.
     * @return
     * @throws ResourceNotFoundException Si no se encuentra el mazo con el ID proporcionado.
     */
    public boolean deleteMazo(@PathVariable(value = "id") int mazoId) throws ResourceNotFoundException {
        Mazo mazo = mazoRepository.findById(mazoId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + mazoId));

        mazoRepository.delete(mazo);
        return false;
    }

}