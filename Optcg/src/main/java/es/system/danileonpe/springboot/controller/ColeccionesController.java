package es.system.danileonpe.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.model.Coleccion;
import es.system.danileonpe.springboot.service.CartaServiceInterface;
import es.system.danileonpe.springboot.service.ColeccionServiceInterface;
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

public class ColeccionesController {

    private ColeccionServiceInterface coleccionService;

    @Autowired
    public void setColeccionRepository(ColeccionServiceInterface coleccionService){
        this.coleccionService = coleccionService;
    }


    @Operation(summary = "Get all Coleccion")
    @GetMapping("/coleccion/")
    public List<Coleccion> getAllColeccion() {
        return coleccionService.getAllColeccion();
    }


    @Operation(summary = "Get Coleccion by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "BadRequest")
    })
    @GetMapping("/coleccion/{id}")
    public ResponseEntity<Coleccion> getColeccionById(@PathVariable(value = "id") int coleccionId) throws ResourceNotFoundException{
        Coleccion coleccion = coleccionService.getColeccionById(coleccionId);
        return ResponseEntity.ok().body(coleccion);

    }

    @Operation(summary = "Insert Coleccion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carta created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/add/coleccion/")
    public Coleccion createColeccion(@Valid @RequestBody Coleccion coleccion){
        return coleccionService.createColeccion(coleccion);
    }

    @Operation(summary = "Update Coleccion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coleccion updated successfully"),
            @ApiResponse(responseCode = "404", description = "Coleccion not found")
    })
    @PutMapping("/update/coleccion/{id}")
    public ResponseEntity<Coleccion> updateColeccion(@PathVariable(value = "id") int coleccionId,
                                             @Valid @RequestBody Coleccion coleccionDetails) throws ResourceNotFoundException {
        Coleccion updateColeccion = coleccionService.updateColeccion(coleccionId, coleccionDetails);
        return ResponseEntity.ok().body(updateColeccion);
    }

    @Operation(summary = "Delete Coleccion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coleccion deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Coleccion not found")
    })
    @DeleteMapping("/delete/coleccion/{id}")
    public Map<String, Boolean> deleteColeccion(@PathVariable(value = "id") int coleccionId) throws ResourceNotFoundException {
        coleccionService.deleteColeccion(coleccionId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}