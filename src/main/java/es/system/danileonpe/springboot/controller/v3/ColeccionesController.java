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

import es.system.danileonpe.springboot.DTO.ColeccionDTO;
import es.system.danileonpe.springboot.mapper.ColeccionMapper;
import es.system.danileonpe.springboot.service.rest.ColeccionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v3/colecciones")
@CrossOrigin
@Tag(name="Coleccionv3", description = "For collections with role admin")
public class ColeccionesController {

    /**
     * Properties
     */
    private ColeccionService service;
    

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
    public void setColeccionService(ColeccionService service) {
        this.service = service;
    }
   

    @Operation(summary = "Insert collection")
    @PostMapping
    public ResponseEntity <?> add(@RequestBody ColeccionDTO dto) {
        System.out.println("Received Coleccion: " + dto);
        service.add(ColeccionMapper.INSTANCE.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update card")
    public ResponseEntity <?> update(@PathVariable(value = "id") int id, @RequestBody ColeccionDTO dto) {
        try {
            service.update(id, ColeccionMapper.INSTANCE.toEntity(dto));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    @Operation(summary = "Get all collections")
    public ResponseEntity<List<?>> getAll() {
        List<ColeccionDTO> filteredList = service.getAll().stream()
                .map(ColeccionMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());


        return ResponseEntity.ok(filteredList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get collections by ID")
    public ResponseEntity<ColeccionDTO> getById(@PathVariable(value = "id") int id) {

        return ResponseEntity.ok(ColeccionMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Operation(summary = "Delete collections")
    @DeleteMapping("/{id}")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}