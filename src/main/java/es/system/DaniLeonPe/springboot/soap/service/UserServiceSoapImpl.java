package es.system.DaniLeonPe.springboot.soap.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.system.DaniLeonPe.springboot.model.User;
import es.system.DaniLeonPe.springboot.service.UserServiceInterface;
import jakarta.jws.WebService;
import jakarta.jws.WebServiceException;

@WebService(endpointInterface = "es.system.DaniLeonPe.springboot.soap.service.UserServiceSoapInterface")
public class UserServiceSoapImpl implements UserServiceSoapInterface{

    private UserServiceInterface userService;

    @Autowired
    public void setUserRepository(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public User getUserById(int userId) {
        try {
            return userService.getUserById(userId);
        } catch (Exception e) {
            throw new WebServiceException("Error obteniendo el usuario", e);
        }
    }
    
}