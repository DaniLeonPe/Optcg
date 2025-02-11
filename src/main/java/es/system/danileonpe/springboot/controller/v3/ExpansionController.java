package es.system.danileonpe.springboot.controller.v3;

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

import es.system.danileonpe.springboot.DTO.ExpansionDTO;
import es.system.danileonpe.springboot.mapper.ExpansionMapper;
import es.system.danileonpe.springboot.service.rest.ExpansionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v3/expansiones")
@CrossOrigin
@Tag(name="Expansionv3", description = "For expansions with role admin")
public class ExpansionController {

    /**
     * Properties
     */
    private ExpansionService service;
    

    /**
     * Default constructor of the class
     */
    public ExpansionController() {
    }


    /**
     * Setter of the service
     * @param service  of the user
     */
    @Autowired
    public void setExpansionService(ExpansionService service) {
        this.service = service;
    }
   

    @Operation(summary = "Insert expansions")
    @PostMapping
    public ResponseEntity <?> add(@RequestBody ExpansionDTO dto) {
        service.add(ExpansionMapper.INSTANCE.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update expansions")
    public ResponseEntity <?> update(@PathVariable(value = "id") int id, @RequestBody ExpansionDTO dto) {
        try {
            service.update(id, ExpansionMapper.INSTANCE.toEntity(dto));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    @Operation(summary = "Get all expansions")
    public ResponseEntity<List<?>> getAll() {
        List<ExpansionDTO> filteredList = service.getAll().stream()
                .map(ExpansionMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());


        return ResponseEntity.ok(filteredList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get expansions by ID")
    public ResponseEntity<ExpansionDTO> getById(@PathVariable(value = "id") int id) {

        return ResponseEntity.ok(ExpansionMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Operation(summary = "Delete expansions")
    @DeleteMapping("/{id}")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}