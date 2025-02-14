package es.ies.puerto.optcg.project.controller.v3;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.optcg.project.dto.CartaDTO;
import es.ies.puerto.optcg.project.mapper.struct.CartaMapper;
import es.ies.puerto.optcg.project.service.rest.impl.CartaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v3/cartas")
@CrossOrigin
@Tag(name="Cartav3", description = "For cards with role admin")
public class CartasController {

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
   

    @Operation(summary = "Insert Card")
    @PostMapping
    public ResponseEntity <?> add(@RequestBody CartaDTO cartaDTO) {
        System.out.println("Received Card: " + cartaDTO);
        service.add(CartaMapper.INSTANCE.toEntity(cartaDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update card")
    public ResponseEntity <?> update(@PathVariable(value = "id") int id, @RequestBody CartaDTO cartaDTO) {
        try {
            service.update(id, CartaMapper.INSTANCE.toEntity(cartaDTO));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    @Operation(summary = "Get all card")
    public ResponseEntity<List<?>> getAll() {
        List<CartaDTO> filteredList = service.getAll().stream()
                .map(CartaMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());


        return ResponseEntity.ok(filteredList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get cards by ID")
    public ResponseEntity<CartaDTO> getById(@PathVariable(value = "id") int id) {

        return ResponseEntity.ok(CartaMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Operation(summary = "Delete cards")
    @DeleteMapping("/{id}")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}