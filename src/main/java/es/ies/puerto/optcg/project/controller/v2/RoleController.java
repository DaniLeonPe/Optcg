package es.ies.puerto.optcg.project.controller.v2;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.ies.puerto.optcg.project.dto.RoleDTO;
import es.ies.puerto.optcg.project.mapper.struct.IRoleMapper;
import es.ies.puerto.optcg.project.service.rest.impl.RoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController("RoleControllerV2")
@RequestMapping("/api/v2/roles")
@CrossOrigin
@Tag(name="v2", description = "For authenticated users")
public class RoleController {
    /**
     * Properties
     */

    private RoleService service;


    /**
     * Default constructor of the class
     */
    public RoleController() {
    }

    /**
     * Setter of the service
     * @param service  of the role
     */
    @Autowired
    public void setRoleService(RoleService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all roles")
    public ResponseEntity<List<?>> getAll() {
        List<RoleDTO> filteredList = service.getAll().stream()
                .map(item -> new RoleDTO(item.getId(), item.getName()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get role by ID")
    public ResponseEntity<RoleDTO> getById(@PathVariable(value = "id")int id) {
        return ResponseEntity.ok(IRoleMapper.INSTANCE.toDTO(service.getById(id)));
    }


}
