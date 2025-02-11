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

import es.system.danileonpe.springboot.DTO.RolDTO;
import es.system.danileonpe.springboot.mapper.RolMapper;
import es.system.danileonpe.springboot.service.rest.RolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v3/roles")
@CrossOrigin
@Tag(name="Rolv3", description = "For rols with role admin")
public class RolController {

    /**
     * Properties
     */
    private RolService service;
    

    /**
     * Default constructor of the class
     */
    public RolController() {
    }


    /**
     * Setter of the service
     * @param service  of the user
     */
    @Autowired
    public void setRolService(RolService service) {
        this.service = service;
    }
   

    @Operation(summary = "Insert rols")
    @PostMapping
    public ResponseEntity <?> add(@RequestBody RolDTO dto) {
        service.add(RolMapper.INSTANCE.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update rols")
    public ResponseEntity <?> update(@PathVariable(value = "id") int id, @RequestBody RolDTO dto) {
        try {
            service.update(id, RolMapper.INSTANCE.toEntity(dto));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    @Operation(summary = "Get all rols")
    public ResponseEntity<List<?>> getAll() {
        List<RolDTO> filteredList = service.getAll().stream()
                .map(RolMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());


        return ResponseEntity.ok(filteredList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get rols by ID")
    public ResponseEntity<RolDTO> getById(@PathVariable(value = "id") int id) {

        return ResponseEntity.ok(RolMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Operation(summary = "Delete rols")
    @DeleteMapping("/{id}")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}