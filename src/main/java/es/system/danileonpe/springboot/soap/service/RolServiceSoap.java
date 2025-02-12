package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.DTO.RolDTO;

import es.system.danileonpe.springboot.mapper.RolMapper;
import es.system.danileonpe.springboot.model.Role;
import es.system.danileonpe.springboot.service.interfaces.IService;
import es.system.danileonpe.springboot.service.interfaces.IServiceSoap;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación SOAP para la gestión de roles.
 */
@Component
@WebService(endpointInterface = "es.system.danileonpe.springboot.service.interfaces.IServiceSoap")
public class RolServiceSoap implements IServiceSoap<RolDTO> {

    private final IService<Role> service;
    @Autowired
    public RolServiceSoap(IService<Role> service) {
        this.service = service;
    }
    
      @Override
    public boolean add(RolDTO t) {
        return service.add(RolMapper.INSTANCE.toEntity(t));
    }

    @Override
    public boolean update(RolDTO t) throws Exception {
       return service.update(t.id(), RolMapper.INSTANCE.toEntity(t));
    }

    @Override
    public List<RolDTO> getAll() {
        return service.getAll().stream()
                .map(RolMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public RolDTO getById(int id) {
        return RolMapper.INSTANCE.toDTO(service.getById(id));
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }

    
}
