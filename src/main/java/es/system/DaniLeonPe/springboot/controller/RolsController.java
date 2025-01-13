package es.system.DaniLeonPe.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.system.DaniLeonPe.springboot.exception.ResourceNotFoundException;
import es.system.DaniLeonPe.springboot.model.Rol;
import es.system.DaniLeonPe.springboot.service.RolServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/v1")

public class RolsController {

    private RolServiceInterface rolService;

    @Autowired
    public void setRolRepository(RolServiceInterface rolService){
        this.rolService = rolService;
    }
    

    @Operation(summary = "Get all rols")
    @GetMapping("/rols/")
    public List<Rol> getAllRols() {
        return rolService.getAllRols();
    }


    @Operation(summary = "Get rol by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "404", description = "BadRequest")
    })
    @GetMapping("/rol/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable(value = "id") int rolId) throws ResourceNotFoundException{
        Rol rol = rolService.getRolById(rolId);
        return ResponseEntity.ok().body(rol);
    
    }
    
    @Operation(summary = "Insert rol")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Rol created successfully"),
        @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/add/rol/")
    public Rol createRol(@Valid @RequestBody Rol rol){
        return rolService.createRol(rol);
    }

    @Operation(summary = "Update rol")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Rol updated successfully"),
        @ApiResponse(responseCode = "404", description = "Rol not found")
    })
    @PutMapping("/update/rol/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable(value = "id") int rolId,
                                           @Valid @RequestBody Rol rolDetails) throws ResourceNotFoundException {
        Rol updatedRol = rolService.updateRol(rolId, rolDetails);
        return ResponseEntity.ok().body(updatedRol);
    }

    @Operation(summary = "Delete rol")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Rol deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Rol not found")
    })
    @DeleteMapping("/delete/rol/{id}")
    public Map<String, Boolean> deleteRol(@PathVariable(value = "id") int rolId) throws ResourceNotFoundException {
        rolService.deleteRol(rolId); 
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
