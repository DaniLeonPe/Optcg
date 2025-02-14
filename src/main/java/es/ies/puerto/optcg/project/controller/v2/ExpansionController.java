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

import es.ies.puerto.optcg.project.dto.ExpansionDTO;
import es.ies.puerto.optcg.project.mapper.struct.ExpansionMapper;
import es.ies.puerto.optcg.project.service.rest.impl.ExpansionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;




@RestController("ExpansionControllerV2")
@RequestMapping("/api/v2/Expansiones")
@CrossOrigin
@Tag(name = "Expansion", description = "API para gestionar Expansiones")
public class ExpansionController {


    private ExpansionService service;

    public ExpansionController(){

    }

    @Autowired
    public ExpansionController(ExpansionService service){
        this.service = service;
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
}