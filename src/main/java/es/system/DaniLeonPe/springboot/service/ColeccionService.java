package es.system.danileonpe.springboot.service;


import java.util.List;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Coleccion;
import es.system.danileonpe.springboot.repository.ColeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;


/**
 * Servicio para la gestión de coleccion.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Coleccion.
 */
@Component
public class ColeccionService implements ColeccionServiceInterface{

    private ColeccionRepository coleccionRepository;


    /**
     * Inyección del repositorio de coleccion.
     *
     * @param coleccionRepository Repositorio de coleccion.
     */
    @Autowired
    public void setColeccionRepository(ColeccionRepository coleccionRepository) {
        this.coleccionRepository = coleccionRepository;
    }


    /**
     * Obtiene todos los coleccion almacenados.
     *
     * @return Lista de coleccion.
     */
    public List<Coleccion> getAllColeccion() {
        return coleccionRepository.findAll();
    }


    /**
     * Obtiene un coleccion por su ID.
     *
     * @param coleccionId Identificador del coleccion.
     * @return El coleccion encontrado.
     * @throws ResourceNotFoundException Si no se encuentra el coleccion con el ID proporcionado.
     */
    public Coleccion getColeccionById(@PathVariable(value = "id") int coleccionId) throws ResourceNotFoundException {
        return coleccionRepository.findById(coleccionId)
                .orElseThrow(() -> new ResourceNotFoundException("Carta not found for this id :: " + coleccionId));
    }


    /**
     * Crea un nuevo coleccion.
     *
     * @param coleccion Detalles del coleccion a crear.
     * @return El coleccion creado.
     */
    public Coleccion createColeccion(@Valid @RequestBody Coleccion coleccion) {
        return coleccionRepository.save(coleccion);
    }

    /**
     * Actualiza un coleccion existente.
     *
     * @param coleccionId Identificador del coleccion a actualizar.
     * @param coleccionDetails Detalles actualizados del coleccion.
     * @return El coleccion actualizado.
     * @throws ResourceNotFoundException Si no se encuentra el coleccion con el ID proporcionado.
     */
    public Coleccion updateColeccion(@PathVariable(value = "id") int coleccionId,
                             @Valid @RequestBody Coleccion coleccionDetails) throws ResourceNotFoundException {
        Coleccion coleccion = coleccionRepository.findById(coleccionId)
                .orElseThrow(() -> new ResourceNotFoundException("Coleccion not found for this id :: " + coleccionId));

        coleccion.setCarta(coleccionDetails.getCarta());
        return coleccionRepository.save(coleccion);
    }


    /**
     * Elimina un coleccion por su ID.
     *
     * @param coleccionId Identificador del coleccion a eliminar.
     * @return
     * @throws ResourceNotFoundException Si no se encuentra el coleccion con el ID proporcionado.
     */
    public boolean deleteColeccion(@PathVariable(value = "id") int coleccionId) throws ResourceNotFoundException {
        Coleccion coleccion = coleccionRepository.findById(coleccionId)
                .orElseThrow(() -> new ResourceNotFoundException("Coleccion not found for this id :: " + coleccionId));

        coleccionRepository.delete(coleccion);
        return false;
    }

}