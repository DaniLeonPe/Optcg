package es.system.danileonpe.springboot.controller.v2;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.system.danileonpe.springboot.DTO.UsuarioDTO;
import es.system.danileonpe.springboot.mapper.UsuarioMapper;
import es.system.danileonpe.springboot.service.rest.UserService;

@RestController("UserControllerV2")
@RequestMapping("/api/v2/users")
@CrossOrigin
@Tag(name = "v2", description = "Authenticated Users")
public class UsersController {

    private UserService service;

    public UsersController(){

    }

    @Autowired
    public UsersController(UserService service ){
        this.service = service;
        
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        List<UsuarioDTO> filteredList = service.getAll().stream()
                .map(UsuarioMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(filteredList);
    }

    @Operation(summary = "Get user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(UsuarioMapper.INSTANCE.toDTO(service.getById(id)));
    }


}
