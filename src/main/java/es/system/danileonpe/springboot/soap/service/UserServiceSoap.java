package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.DTO.UsuarioDTO;
import es.system.danileonpe.springboot.mapper.UsuarioMapper;
import es.system.danileonpe.springboot.model.Usuario;
import es.system.danileonpe.springboot.service.interfaces.IService;
import es.system.danileonpe.springboot.service.interfaces.IServiceSoap;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio SOAP para la gestión de usuarios.
 * Proporciona operaciones CRUD para la entidad Usuario.
 */
@Component
@WebService(endpointInterface = "es.system.danileonpe.springboot.service.interfaces.IServiceSoap")
public class UserServiceSoap implements IServiceSoap<UsuarioDTO> {

    private final IService<Usuario> service;

    @Autowired
    public UserServiceSoap(IService<Usuario> service) {
        this.service = service;
    }

    @Override
    public boolean add(UsuarioDTO t) {
        return service.add(UsuarioMapper.INSTANCE.toEntity(t));
    }

    @Override
    public boolean update(UsuarioDTO t) throws Exception {
       return service.update(t.id(), UsuarioMapper.INSTANCE.toEntity(t));
    }

    @Override
    public List<UsuarioDTO> getAll() {
        return service.getAll().stream()
                .map(UsuarioMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO getById(int id) {
        return UsuarioMapper.INSTANCE.toDTO(service.getById(id));
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}
