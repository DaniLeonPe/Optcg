package es.system.danileonpe.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Mazo;
import es.system.danileonpe.springboot.service.MazoServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/v1")

public class MazosController {

    private MazoServiceInterface mazoService;

    @Autowired
    public void setMazoRepository(MazoServiceInterface mazoService){
        this.mazoService = mazoService;
    }


    @Operation(summary = "Get all Mazo")
    @GetMapping("/mazos/")
    public List<Mazo> getAllMazo() {
        return mazoService.getAllMazo();
    }


    @Operation(summary = "Get Mazo by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "BadRequest")
    })
    @GetMapping("/mazo/{id}")
    public ResponseEntity<Mazo> getMazoById(@PathVariable(value = "id") int mazoId) throws ResourceNotFoundException {
        Mazo mazo = mazoService.getMazoById(mazoId);
        return ResponseEntity.ok().body(mazo);

    }

    @Operation(summary = "Insert Mazo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mazo created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/add/mazo/")
    public Mazo createMazo(@Valid @RequestBody Mazo mazo){
        return mazoService.createMazo(mazo);
    }

    @Operation(summary = "Update Mazo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mazo updated successfully"),
            @ApiResponse(responseCode = "404", description = "Mazo not found")
    })
    @PutMapping("/update/mazo/{id}")
    public ResponseEntity<Mazo> updateMazo(@PathVariable(value = "id") int mazoId,
                                             @Valid @RequestBody Mazo mazoDetails) throws ResourceNotFoundException {
        Mazo updateMazo = mazoService.updateMazo(mazoId, mazoDetails);
        return ResponseEntity.ok().body(updateMazo);
    }

    @Operation(summary = "Delete Mazo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mazo deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Mazo not found")
    })
    @DeleteMapping("/delete/mazo/{id}")
    public Map<String, Boolean> deleteMazo(@PathVariable(value = "id") int mazoId) throws ResourceNotFoundException {
        mazoService.deleteMazo(mazoId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}