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

import es.system.danileonpe.springboot.DTO.MazoDTO;
import es.system.danileonpe.springboot.mapper.MazoMapper;
import es.system.danileonpe.springboot.service.rest.MazoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v3/mazos")
@CrossOrigin
@Tag(name="Mazov3", description = "For mazos with role admin")
public class MazoController {

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
   

    @Operation(summary = "Insert mazos")
    @PostMapping
    public ResponseEntity <?> add(@RequestBody MazoDTO dto) {
        System.out.println("Received Mazo: " + dto);
        service.add(MazoMapper.INSTANCE.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update mazos")
    public ResponseEntity <?> update(@PathVariable(value = "id") int id, @RequestBody MazoDTO dto) {
        try {
            service.update(id, MazoMapper.INSTANCE.toEntity(dto));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    @Operation(summary = "Get all mazos")
    public ResponseEntity<List<?>> getAll() {
        List<MazoDTO> filteredList = service.getAll().stream()
                .map(MazoMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());


        return ResponseEntity.ok(filteredList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get mazos by ID")
    public ResponseEntity<MazoDTO> getById(@PathVariable(value = "id") int id) {

        return ResponseEntity.ok(MazoMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Operation(summary = "Delete mazos")
    @DeleteMapping("/{id}")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}