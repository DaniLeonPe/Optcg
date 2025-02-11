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

import es.system.danileonpe.springboot.DTO.CartaDTO;
import es.system.danileonpe.springboot.mapper.CartaMapper;
import es.system.danileonpe.springboot.service.rest.CartaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController("CartasControllerV2")
@RequestMapping("/api/v2/cartas")
@CrossOrigin
@Tag(name = "Cartas", description = "API para gestionar cartas")
public class CartasController {


    private CartaService service;

    public CartasController(){

    }

    @Autowired
    public CartasController(CartaService service){
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all Cards")
    public ResponseEntity<List<?>> getAll() {
        List<CartaDTO> filteredList = service.getAll().stream()
                .map(CartaMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());


        return ResponseEntity.ok(filteredList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Cards by ID")
    public ResponseEntity<CartaDTO> getById(@PathVariable(value = "id") int id) {

        return ResponseEntity.ok(CartaMapper.INSTANCE.toDTO(service.getById(id)));
    }
}