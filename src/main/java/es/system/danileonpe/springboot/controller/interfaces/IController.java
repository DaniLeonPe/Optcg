package es.system.danileonpe.springboot.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * @author Daniel de León Pérez
 */
public interface IController<T> {
    
    public ResponseEntity<?> add(@RequestBody T t);
    
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody T t);
    
    public ResponseEntity<?> delete(@PathVariable int id);
    
    public ResponseEntity<?> getAll();
    
    public ResponseEntity<?> getById(@PathVariable int id);
}
