package es.system.danileonpe.springboot.soap.service;

import java.util.List;

import es.system.danileonpe.springboot.model.User;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService(targetNamespace = "springboot.soap.service")
public interface UserServiceSoapInterface {
    
    @WebMethod
    @WebResult(
     name="user")
    List<User> getAllUsers();

    @WebMethod
    User getUserById(@WebParam(name = "userId") int userId);
    
}
