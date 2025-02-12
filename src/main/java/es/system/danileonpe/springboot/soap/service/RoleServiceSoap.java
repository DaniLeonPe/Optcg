package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.DTO.RoleDTO;
import es.system.danileonpe.springboot.mapper.IRoleMapper;
import es.system.danileonpe.springboot.model.Role;
import es.system.danileonpe.springboot.service.interfaces.IService;
import es.system.danileonpe.springboot.service.interfaces.IServiceSoap;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación SOAP para la gestión de roles.
 */
@Component
@WebService(endpointInterface = "es.ies.puerto.mgs.project.service.interfaces.IServiceSoap")
public class RoleServiceSoap implements IServiceSoap<RoleDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(RoleServiceSoap.class);

    private IService<Role> service;

    /**
     * Setter of the service
     * @param service restfull
     */
    @Autowired
    public void setService(IService<Role> service) {
        this.service = service;
    }

    /**
     * Default constructor of the class
     */
    public RoleServiceSoap(){}

    @Override
    public boolean add(RoleDTO roleDTO) {
        return service.add(IRoleMapper.INSTANCE.toEntity(roleDTO));
    }

    @Override
    public boolean update(RoleDTO roleDTO) throws Exception {
        return service.update(roleDTO.getId(), IRoleMapper.INSTANCE.toEntity(roleDTO));
    }

    @WebResult(name="role")
    @Override
    public List<RoleDTO> getAll() {
        return service.getAll().stream()
                .map(item -> new RoleDTO(item.getId(), item.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO getById(int id) {
        return IRoleMapper.INSTANCE.toDTO(service.getById(id));
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}