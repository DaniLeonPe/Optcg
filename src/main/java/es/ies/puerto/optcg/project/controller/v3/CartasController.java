package es.ies.puerto.optcg.project.controller.v3;

import java.util.List;
import java.util.stream.Collectors;

import es.ies.puerto.optcg.project.controller.interfaces.IController;
import es.ies.puerto.optcg.project.dto.ExpansionDTO;
import es.ies.puerto.optcg.project.mapper.struct.ExpansionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.ies.puerto.optcg.project.dto.CartaDTO;
import es.ies.puerto.optcg.project.mapper.struct.CartaMapper;
import es.ies.puerto.optcg.project.service.rest.impl.CartaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v3/cartas")
@CrossOrigin
@Tag(name="Cartav3", description = "For cards with role admin")
public class CartasController implements IController<CartaDTO> {

    /**
     * Properties
     */
    private CartaService service;
    

    /**
     * Default constructor of the class
     */
    public CartasController() {
    }


    /**
     * Setter of the service
     * @param service  of the user
     */
    @Autowired
    public void setCartaService(CartaService service) {
        this.service = service;
    }


    @Override
    @PostMapping
    public ResponseEntity<?> add(@RequestBody CartaDTO dto) {
        service.add(CartaMapper.INSTANCE.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/{id}")
    @Operation(summary = "Update role")
    @Override
    public ResponseEntity <?>update(@PathVariable(value = "id") int id, @RequestBody CartaDTO dto) {
        try {
            service.update(id, CartaMapper.INSTANCE.toEntity(dto));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    @Operation(summary = "Get all roles")
    @Override
    public ResponseEntity<List<?>> getAll() {
        List<CartaDTO> filteredList = service.getAll().stream()
                .map(item -> new CartaDTO(item.getId(), item.getNombre(),item.getTipo(),
                        item.getRareza(),item.getCosto(),
                        item.getDescripcion(),item.getExpansion().getId(),
                        item.getImagenUrl()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredList);
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get role by ID")
    public ResponseEntity<CartaDTO> getById(@PathVariable(value = "id")int id) {
        return ResponseEntity.ok(CartaMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete role")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}