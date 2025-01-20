package es.system.danileonpe.springboot.service;


import java.util.List;

import es.system.danileonpe.springboot.model.Carta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.repository.CartaRepository;
import jakarta.validation.Valid;


/**
 * Servicio para la gestión de Cartas.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad Carta.
 */
@Component
public class CartaService implements CartaServiceInterface{

    private CartaRepository cartaRepository;


    /**
     * Inyección del repositorio de cartas.
     *
     * @param cartaRepository Repositorio de cartas.
     */
    @Autowired
    public void setCartaRepository(CartaRepository cartaRepository) {
        this.cartaRepository = cartaRepository;
    }


    /**
     * Obtiene todos las carta almacenados.
     *
     * @return Lista de cartas.
     */
    public List<Carta> getAllCartas() {
        return cartaRepository.findAll();
    }


    /**
     * Obtiene un carta por su ID.
     *
     * @param cartaId Identificador del carta.
     * @return El carta encontrado.
     * @throws ResourceNotFoundException Si no se encuentra el carta con el ID proporcionado.
     */
    public Carta getCartaById(@PathVariable(value = "id") int cartaId) throws ResourceNotFoundException {
        return cartaRepository.findById(cartaId)
                .orElseThrow(() -> new ResourceNotFoundException("Carta not found for this id :: " + cartaId));
    }


    /**
     * Crea un nuevo carta.
     *
     * @param carta Detalles del carta a crear.
     * @return El carta creado.
     */
    public Carta createCarta(@Valid @RequestBody Carta carta) {
        return cartaRepository.save(carta);
    }


    /**
     * Actualiza un carta existente.
     *
     * @param cartaId Identificador del carta a actualizar.
     * @param cartaDetails Detalles actualizados del carta.
     * @return El carta actualizado.
     * @throws ResourceNotFoundException Si no se encuentra el carta con el ID proporcionado.
     */
    public Carta updateCarta(@PathVariable(value = "id") int cartaId,
                              @Valid @RequestBody Carta cartaDetails) throws ResourceNotFoundException {
        Carta carta = cartaRepository.findById(cartaId)
                .orElseThrow(() -> new ResourceNotFoundException("Carta not found for this id :: " + cartaId));

        carta.setNombre(cartaDetails.getNombre());
        return cartaRepository.save(carta);
    }


    /**
     * Elimina un carta por su ID.
     *
     * @param cartaId Identificador del carta a eliminar.
     * @return
     * @throws ResourceNotFoundException Si no se encuentra el carta con el ID proporcionado.
     */
    public boolean deleteCarta(@PathVariable(value = "id") int cartaId) throws ResourceNotFoundException {
        Carta carta = cartaRepository.findById(cartaId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + cartaId));

        cartaRepository.delete(carta);
        return false;
    }

}