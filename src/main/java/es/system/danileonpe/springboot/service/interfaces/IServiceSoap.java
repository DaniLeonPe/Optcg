package es.system.danileonpe.springboot.service.interfaces;

import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(targetNamespace = "es.system.danileonpe.springboot.service.interfaces")
public interface IServiceSoap<T>{
    @WebMethod
    boolean add(T t);
    @WebMethod
    boolean update(@WebParam(name = "item") T t) throws Exception;
    @WebMethod
    List<T> getAll();
    @WebMethod
    T getById(@WebParam(name = "id") int id);
    @WebMethod
    boolean delete(@WebParam(name = "id") int id);
}
