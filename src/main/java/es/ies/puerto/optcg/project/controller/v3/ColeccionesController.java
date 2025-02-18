package es.ies.puerto.optcg.project.controller.v3;

import java.util.List;
import java.util.stream.Collectors;

import es.ies.puerto.optcg.project.controller.interfaces.IController;
import es.ies.puerto.optcg.project.dto.RoleDTO;
import es.ies.puerto.optcg.project.mapper.struct.IRoleMapper;
import es.ies.puerto.optcg.project.model.entities.Carta;
import es.ies.puerto.optcg.project.model.entities.Coleccion;
import es.ies.puerto.optcg.project.model.entities.User;
import es.ies.puerto.optcg.project.repository.jpa.dao.CartaRepository;
import es.ies.puerto.optcg.project.repository.jpa.dao.IDaoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.ies.puerto.optcg.project.dto.ColeccionDTO;
import es.ies.puerto.optcg.project.mapper.struct.ColeccionMapper;
import es.ies.puerto.optcg.project.service.rest.impl.ColeccionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v3/colecciones")
@CrossOrigin
@Tag(name="Coleccionv3", description = "For collections with role admin")
public class ColeccionesController implements IController<ColeccionDTO> {

    /**
     * Properties
     */
    private ColeccionService service;
    private IDaoUser repository;
    private CartaRepository cartaRepository;
    

    /**
     * Default constructor of the class
     */
    public ColeccionesController() {
    }


    /**
     * Setter of the service
     * @param service  of the user
     */
    @Autowired
    public void setColeccionService(
            ColeccionService service, IDaoUser repository, CartaRepository cartaRepository) {
        this.service = service;
        this.repository = repository;
        this.cartaRepository = cartaRepository;
    }


    @Override
    @PostMapping
    @Operation(summary = "Insert role")
    public ResponseEntity <?>add(@org.springframework.web.bind.annotation.RequestBody ColeccionDTO dto) {
        service.add(ColeccionMapper.INSTANCE.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update role")
    @Override
    public ResponseEntity <?>update(@PathVariable(value = "id") int id, @RequestBody ColeccionDTO dto) {
        try {
            service.update(id, ColeccionMapper.INSTANCE.toEntity(dto));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    @Operation(summary = "Get all roles")
    @Override
    public ResponseEntity<List<?>> getAll() {
        List<ColeccionDTO> filteredList = service.getAll().stream()
                .map(item -> new ColeccionDTO(item.getId(), item.getUsuario().getId(),item.getCarta().getId(),item.getCantidad()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredList);
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get role by ID")
    public ResponseEntity<ColeccionDTO> getById(@PathVariable(value = "id")int id) {
        return ResponseEntity.ok(ColeccionMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete role")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}