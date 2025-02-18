package es.ies.puerto.optcg.project.controller.v3;

import java.util.List;
import java.util.stream.Collectors;

import es.ies.puerto.optcg.project.controller.interfaces.IController;
import es.ies.puerto.optcg.project.dto.RoleDTO;
import es.ies.puerto.optcg.project.mapper.struct.IRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.ies.puerto.optcg.project.dto.MazoDTO;
import es.ies.puerto.optcg.project.mapper.struct.MazoMapper;
import es.ies.puerto.optcg.project.service.rest.impl.MazoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v3/mazos")
@CrossOrigin
@Tag(name="Mazov3", description = "For mazos with role admin")
public class MazoController implements IController<MazoDTO> {

    /**
     * Properties
     */
    private MazoService service;
    

    /**
     * Default constructor of the class
     */
    public MazoController() {
    }


    /**
     * Setter of the service
     * @param service  of the user
     */
    @Autowired
    public void setMazoService(MazoService service) {
        this.service = service;
    }


    @Override
    @PostMapping
    @Operation(summary = "Insert role")
    public ResponseEntity <?>add(@org.springframework.web.bind.annotation.RequestBody MazoDTO dto) {
        service.add(MazoMapper.INSTANCE.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update role")
    @Override
    public ResponseEntity <?>update(@PathVariable(value = "id") int id, @RequestBody MazoDTO dto) {
        try {
            service.update(id, MazoMapper.INSTANCE.toEntity(dto));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    @Operation(summary = "Get all roles")
    @Override
    public ResponseEntity<List<?>> getAll() {
        List<MazoDTO> filteredList = service.getAll().stream()
                .map(item -> new MazoDTO(item.getId(),item.getUsuario().getId(),item.getNombre(),item.getDescripcion(),item.getFechaCreacion()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredList);
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get role by ID")
    public ResponseEntity<MazoDTO> getById(@PathVariable(value = "id")int id) {
        return ResponseEntity.ok(MazoMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete role")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}