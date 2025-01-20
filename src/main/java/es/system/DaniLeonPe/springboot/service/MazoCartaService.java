package es.system.danileonpe.springboot.service;

import java.util.List;

import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.model.MazoCarta;
import es.system.danileonpe.springboot.model.MazoCartaId;
import es.system.danileonpe.springboot.repository.MazoCartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.repository.CartaRepository;
import jakarta.validation.Valid;

/**
 * Servicio para la gestión de mazosCartas.
 * Proporciona métodos para realizar operaciones CRUD sobre la entidad MazoCarta.
 */
@Component
public class MazoCartaService implements MazoCartaServiceInterface {

    private MazoCartaRepository mazoCartaRepository;

    /**
     * Inyección del repositorio de mazosCartas.
     *
     * @param mazoCartaRepository Repositorio de mazosCartas.
     */
    @Autowired
    public void setMazoCartaRepository(MazoCartaRepository mazoCartaRepository) {
        this.mazoCartaRepository = mazoCartaRepository;
    }

    /**
     * Obtiene todos los MazoCarta almacenados.
     *
     * @return Lista de MazoCarta.
     */
    @Override
    public List<MazoCarta> getAllMazoCarta() {
        return mazoCartaRepository.findAll();
    }

    /**
     * Obtiene un MazoCarta por su clave compuesta.
     *
     * @param mazoId  Identificador del mazo.
     * @param cartaId Identificador de la carta.
     * @return El MazoCarta encontrado.
     * @throws ResourceNotFoundException Si no se encuentra el MazoCarta con la clave compuesta proporcionada.
     */
    @Override
    public MazoCarta getMazoCartaById(long mazoId, long cartaId) throws ResourceNotFoundException {
        MazoCartaId mazoCartaId = new MazoCartaId();
        mazoCartaId.setMazo(mazoId);
        mazoCartaId.setCarta(cartaId);

        return mazoCartaRepository.findById(mazoCartaId)
                .orElseThrow(() -> new ResourceNotFoundException("MazoCarta not found for this id :: " + mazoId + ", " + cartaId));
    }

    /**
     * Crea un nuevo MazoCarta.
     *
     * @param mazoCarta Detalles del MazoCarta a crear.
     * @return El MazoCarta creado.
     */
    @Override
    public MazoCarta createMazoCarta(MazoCarta mazoCarta) {
        return mazoCartaRepository.save(mazoCarta);
    }

    /**
     * Actualiza un MazoCarta existente.
     *
     * @param mazoId         Identificador del mazo.
     * @param cartaId        Identificador de la carta.
     * @param mazoCartaDetails Detalles actualizados del MazoCarta.
     * @return El MazoCarta actualizado.
     * @throws ResourceNotFoundException Si no se encuentra el MazoCarta con la clave compuesta proporcionada.
     */

    public MazoCarta updateMazoCarta(long mazoId, long cartaId, MazoCarta mazoCartaDetails) throws ResourceNotFoundException {
        MazoCartaId mazoCartaId = new MazoCartaId();
        mazoCartaId.setMazo(mazoId);
        mazoCartaId.setCarta(cartaId);

        MazoCarta mazoCarta = mazoCartaRepository.findById(mazoCartaId)
                .orElseThrow(() -> new ResourceNotFoundException("MazoCarta not found for this id :: " + mazoId + ", " + cartaId));

        mazoCarta.setCantidad(mazoCartaDetails.getCantidad());
        return mazoCartaRepository.save(mazoCarta);
    }

    /**
     * Elimina un MazoCarta por su clave compuesta.
     *
     * @param mazoId  Identificador del mazo.
     * @param cartaId Identificador de la carta.
     * @throws ResourceNotFoundException Si no se encuentra el MazoCarta con la clave compuesta proporcionada.
     */

    public void deleteMazoCarta(long mazoId, long cartaId) throws ResourceNotFoundException {
        MazoCartaId mazoCartaId = new MazoCartaId();
        mazoCartaId.setMazo(mazoId);
        mazoCartaId.setCarta(cartaId);

        MazoCarta mazoCarta = mazoCartaRepository.findById(mazoCartaId)
                .orElseThrow(() -> new ResourceNotFoundException("MazoCarta not found for this id :: " + mazoId + ", " + cartaId));

        mazoCartaRepository.delete(mazoCarta);
    }
}
