package es.system.danileonpe.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.service.CartaServiceInterface;
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

public class CartasController {

    private CartaServiceInterface cartaService;

    @Autowired
    public void setCartaRepository(CartaServiceInterface cartaService){
        this.cartaService = cartaService;
    }


    @Operation(summary = "Get all cartas")
    @GetMapping("/cartas/")
    public List<Carta> getAllCartas() {
        return cartaService.getAllCartas();
    }


    @Operation(summary = "Get Carta by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "BadRequest")
    })
    @GetMapping("/carta/{id}")
    public ResponseEntity<Carta> getCartaById(@PathVariable(value = "id") int cartaId) throws ResourceNotFoundException{
        Carta carta = cartaService.getCartaById(cartaId);
        return ResponseEntity.ok().body(carta);

    }

    @Operation(summary = "Insert carta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carta created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/add/carta/")
    public Carta createCarta(@Valid @RequestBody Carta carta){
        return cartaService.createCarta(carta);
    }

    @Operation(summary = "Update carta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carta updated successfully"),
            @ApiResponse(responseCode = "404", description = "Carta not found")
    })
    @PutMapping("/update/carta/{id}")
    public ResponseEntity<Carta> updateCarta(@PathVariable(value = "id") int cartaId,
                                         @Valid @RequestBody Carta cartaDetails) throws ResourceNotFoundException {
        Carta updateCarta = cartaService.updateCarta(cartaId, cartaDetails);
        return ResponseEntity.ok().body(updateCarta);
    }

    @Operation(summary = "Delete Carta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carta deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Carta not found")
    })
    @DeleteMapping("/delete/carta/{id}")
    public Map<String, Boolean> deleteCarta(@PathVariable(value = "id") int cartaId) throws ResourceNotFoundException {
        cartaService.deleteCarta(cartaId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}