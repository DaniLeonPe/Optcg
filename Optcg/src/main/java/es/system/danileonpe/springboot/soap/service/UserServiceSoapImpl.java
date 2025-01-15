package es.system.danileonpe.springboot.soap.service;

import java.util.List;

import es.system.danileonpe.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import es.system.danileonpe.springboot.service.UserServiceInterface;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;

@WebService(endpointInterface = "es.system.danileonpe.springboot.soap.service.UserServiceSoapInterface")
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
