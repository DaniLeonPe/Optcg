package es.system.danileonpe.springboot.controller.v3;

import java.util.List;
import java.util.stream.Collectors;

import es.system.danileonpe.springboot.DTO.UsuarioAddDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.system.danileonpe.springboot.DTO.UsuarioDTO;
import es.system.danileonpe.springboot.mapper.UsuarioMapper;
import es.system.danileonpe.springboot.model.Usuario;
import es.system.danileonpe.springboot.service.rest.RoleService;
import es.system.danileonpe.springboot.service.rest.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/users")
@CrossOrigin
@Tag(name="Userv3", description = "For users with role admin")
public class UsersController {

    /**
     * Properties
     */
    private UserService service;
    private RoleService roleService;

    /**
     * Default constructor of the class
     */
    public UsersController() {
    }


    /**
     * Setter of the service
     * @param service  of the user
     */
    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }
    /**
     * Setter of the service
     * @param roleService  of the role
     */
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    @Operation(summary = "Insert user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity <?>add(@RequestBody UsuarioAddDTO dto) {
        if(dto == null){
            return ResponseEntity.badRequest()
                    .body("User can not be null");
        }

        Usuario dbItemByName = service.getByName(dto.name());

        if (dbItemByName != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Name already in use");
        }

        Usuario dbItemByEmail = service.getByEmail(dto.email());

        if (dbItemByEmail != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already in use");
        }


        Usuario aux = new Usuario();
        aux.setName(dto.name());
        aux.setEmail(dto.email());
        aux.setPassword(dto.password());
        aux.setRole(roleService.getById(dto.role()));

        service.add(aux);

        UsuarioDTO result = UsuarioMapper.INSTANCE.toDTO(service.getByName(dto.name()));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Successfully created");
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity <?> update(@PathVariable(value = "id") int id, @RequestBody UsuarioDTO dto) {
        try {
            service.update(id, UsuarioMapper.INSTANCE.toEntity(dto));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    @Operation(summary = "Delete user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}