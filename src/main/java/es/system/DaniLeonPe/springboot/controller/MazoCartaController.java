package es.system.danileonpe.springboot.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;


import es.system.danileonpe.springboot.service.MazoCartaServiceInterface;

import es.system.danileonpe.springboot.model.MazoCarta;
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
public class MazoCartaController {

    private final MazoCartaServiceInterface mazoCartaService;

    @Autowired
    public MazoCartaController(MazoCartaServiceInterface mazoCartaService) {
        this.mazoCartaService = mazoCartaService;
    }

    @Operation(summary = "Get all MazoCarta")
    @GetMapping("/mazos-cartas")
    public List<MazoCarta> getAllMazoCarta() {
        return mazoCartaService.getAllMazoCarta();
    }

    @Operation(summary = "Get MazoCarta by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "MazoCarta not found")
    })
    @GetMapping("/mazos-cartas/{mazoId}/{cartaId}")
    public ResponseEntity<MazoCarta> getMazoCartaById(@PathVariable Long mazoId, @PathVariable Long cartaId) throws ResourceNotFoundException {
        MazoCarta mazoCarta = mazoCartaService.getMazoCartaById(mazoId, cartaId);
        return ResponseEntity.ok(mazoCarta);
    }

    @Operation(summary = "Insert MazoCarta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "MazoCarta created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/mazos-cartas")
    public ResponseEntity<MazoCarta> createMazoCarta(@Valid @RequestBody MazoCarta mazoCarta) {
        MazoCarta createdMazoCarta = mazoCartaService.createMazoCarta(mazoCarta);
        return ResponseEntity.status(201).body(createdMazoCarta);
    }

    @Operation(summary = "Update MazoCarta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "MazoCarta updated successfully"),
            @ApiResponse(responseCode = "404", description = "MazoCarta not found")
    })
    @PutMapping("/mazos-cartas/{mazoId}/{cartaId}")
    public ResponseEntity<MazoCarta> updateMazoCarta(@PathVariable Long mazoId,
                                                     @PathVariable Long cartaId,
                                                     @Valid @RequestBody MazoCarta mazoCartaDetails) throws ResourceNotFoundException {
        MazoCarta updatedMazoCarta = mazoCartaService.updateMazoCarta(mazoId, cartaId, mazoCartaDetails);
        return ResponseEntity.ok(updatedMazoCarta);
    }

    @Operation(summary = "Delete MazoCarta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "MazoCarta deleted successfully"),
            @ApiResponse(responseCode = "404", description = "MazoCarta not found")
    })
    @DeleteMapping("/mazos-cartas/{mazoId}/{cartaId}")
    public ResponseEntity<Map<String, Boolean>> deleteMazoCarta(@PathVariable Long mazoId, @PathVariable Long cartaId) throws ResourceNotFoundException {
        mazoCartaService.deleteMazoCarta(mazoId, cartaId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
