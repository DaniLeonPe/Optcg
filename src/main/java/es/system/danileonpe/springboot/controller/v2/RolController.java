package es.system.danileonpe.springboot.controller.v2;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.system.danileonpe.springboot.DTO.RolDTO;
import es.system.danileonpe.springboot.mapper.RolMapper;
import es.system.danileonpe.springboot.service.rest.RolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController("RolControllerV2")
@RequestMapping("/api/v2/roles")
@CrossOrigin
@Tag(name = "roles", description = "API para gestionar roles")
public class RolController {


    private RolService service;

    public RolController(){

    }

    @Autowired
    public RolController(RolService service){
        this.service = service;
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
}