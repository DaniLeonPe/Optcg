package es.system.danileonpe.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.system.danileonpe.springboot.model.Expansion;
import es.system.danileonpe.springboot.service.ExpansionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/v1")

public class ExpansionesController {

    private ExpansionServiceInterface expansionService;

    @Autowired
    public void setExpansionRepository(ExpansionServiceInterface expansionService){
        this.expansionService = expansionService;
    }


    @Operation(summary = "Get all Expansion")
    @GetMapping("/expanciones/")
    public List<Expansion> getAllExpansion() {
        return expansionService.getAllExpansion();
    }


    @Operation(summary = "Get Expansion by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "BadRequest")
    })
    @GetMapping("/expansion/{id}")
    public ResponseEntity<Expansion> getExpansionById(@PathVariable(value = "id") int expansionId) throws ResourceNotFoundException{
        Expansion expansion = expansionService.getExpansionById(expansionId);
        return ResponseEntity.ok().body(expansion);

    }

    @Operation(summary = "Insert Expansion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expansion created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/add/expansion/")
    public Expansion createExpansion(@Valid @RequestBody Expansion expansion){
        return expansionService.createExpansion(expansion);
    }

    @Operation(summary = "Update Expansion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expansion updated successfully"),
            @ApiResponse(responseCode = "404", description = "Expansion not found")
    })
    @PutMapping("/update/expansion/{id}")
    public ResponseEntity<Expansion> updateExpansion(@PathVariable(value = "id") int expansionId,
                                             @Valid @RequestBody Expansion expansionDetails) throws ResourceNotFoundException {
        Expansion updateExpansion = expansionService.updateExpansion(expansionId, expansionDetails);
        return ResponseEntity.ok().body(updateExpansion);
    }

    @Operation(summary = "Delete Expansion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expansion deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Expansion not found")
    })
    @DeleteMapping("/delete/expansion/{id}")
    public Map<String, Boolean> deleteExpansion(@PathVariable(value = "id") int expansionId) throws ResourceNotFoundException {
        expansionService.deleteExpansion(expansionId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}