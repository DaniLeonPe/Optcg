package es.ies.puerto.optcg.project.controller.v3;

import java.util.List;
import java.util.stream.Collectors;

import es.ies.puerto.optcg.project.dto.RoleDTO;
import es.ies.puerto.optcg.project.mapper.struct.IRoleMapper;
import es.ies.puerto.optcg.project.model.entities.Expansion;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.ies.puerto.optcg.project.controller.interfaces.IController;
import es.ies.puerto.optcg.project.dto.ExpansionDTO;
import es.ies.puerto.optcg.project.mapper.struct.ExpansionMapper;
import es.ies.puerto.optcg.project.service.rest.impl.ExpansionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v3/expansiones")
@CrossOrigin
@Tag(name="Expansionv3", description = "For expansions with role admin")
public class ExpansionController implements IController<ExpansionDTO>{

    private ExpansionService service;

    public ExpansionController() {}

    @Autowired
    public void setExpansionService(ExpansionService service){
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<?> add(@RequestBody ExpansionDTO expansionDTO) {
        service.add(ExpansionMapper.INSTANCE.toEntity(expansionDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/{id}")
    @Operation(summary = "Update role")
    @Override
    public ResponseEntity <?>update(@PathVariable(value = "id") int id, @RequestBody ExpansionDTO dto) {
        try {
            service.update(id, ExpansionMapper.INSTANCE.toEntity(dto));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    @Operation(summary = "Get all roles")
    @Override
    public ResponseEntity<List<?>> getAll() {
        List<ExpansionDTO> filteredList = service.getAll().stream()
                .map(item -> new ExpansionDTO(item.getId(), item.getNombre(), item.getFechaLanzamiento()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredList);
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get role by ID")
    public ResponseEntity<ExpansionDTO> getById(@PathVariable(value = "id")int id) {
        return ResponseEntity.ok(ExpansionMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete role")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}