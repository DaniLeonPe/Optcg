package es.ies.puerto.optcg.project.controller.v2;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.optcg.project.dto.ColeccionDTO;
import es.ies.puerto.optcg.project.mapper.struct.ColeccionMapper;
import es.ies.puerto.optcg.project.service.rest.impl.ColeccionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;




@RestController("ColeccionesControllerV2")
@RequestMapping("/api/v2/colecciones")
@CrossOrigin
@Tag(name = "Colecciones", description = "v2 de colecciones")
public class ColleccionesController {


    private ColeccionService service;

    public ColleccionesController(){

    }

    @Autowired
    public ColleccionesController(ColeccionService service){
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all Colecciones")
    public ResponseEntity<List<?>> getAll() {
        List<ColeccionDTO> filteredList = service.getAll().stream()
                .map(ColeccionMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());


        return ResponseEntity.ok(filteredList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Colecciones by ID")
    public ResponseEntity<ColeccionDTO> getById(@PathVariable(value = "id") int id) {

        return ResponseEntity.ok(ColeccionMapper.INSTANCE.toDTO(service.getById(id)));
    }
}