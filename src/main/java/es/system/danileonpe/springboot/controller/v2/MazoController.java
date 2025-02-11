package es.system.danileonpe.springboot.controller.v2;


import java.util.List;
import java.util.stream.Collectors;

import es.system.danileonpe.springboot.DTO.MazoDTO;
import es.system.danileonpe.springboot.mapper.MazoMapper;
import es.system.danileonpe.springboot.service.rest.MazoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;




@RestController("MazoControllerV2")
@RequestMapping("/api/v2/Mazos")
@CrossOrigin
@Tag(name = "Mazos", description = "API para gestionar Mazos")
public class MazoController {


    private MazoService service;

    public MazoController(){

    }

    @Autowired
    public MazoController(MazoService service){
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all Cards")
    public ResponseEntity<List<?>> getAll() {
        List<MazoDTO> filteredList = service.getAll().stream()
                .map(MazoMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());


        return ResponseEntity.ok(filteredList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Cards by ID")
    public ResponseEntity<MazoDTO> getById(@PathVariable(value = "id") int id) {

        return ResponseEntity.ok(MazoMapper.INSTANCE.toDTO(service.getById(id)));
    }
}