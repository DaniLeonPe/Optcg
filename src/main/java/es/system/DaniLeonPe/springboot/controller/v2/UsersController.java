package es.system.danileonpe.springboot.controller.v2;

import io.swagger.v3.oas.annotations.tags.Tag;


import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.system.danileonpe.springboot.service.rest.UserService;

@RestController("UserControllerV2")
@RequestMapping("/api/v2/users")
@CrossOrigin
@Tag(name = "v2", description = "Authenticated Users")
public class UsersController {

    private UserService userService;
}
