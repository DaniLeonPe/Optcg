package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.DTO.ColeccionDTO;
import es.system.danileonpe.springboot.mapper.ColeccionMapper;
import es.system.danileonpe.springboot.model.Coleccion;
import es.system.danileonpe.springboot.service.interfaces.IService;
import es.system.danileonpe.springboot.service.interfaces.IServiceSoap;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@WebService(endpointInterface = "es.system.danileonpe.springboot.service.interfaces.IServiceSoap")
public class ColeccionServiceSoap implements IServiceSoap<ColeccionDTO> {

   private final IService<Coleccion> service;

    @Autowired
    public ColeccionServiceSoap(IService<Coleccion> service) {
        this.service = service;
    }

@Override
    public boolean add(ColeccionDTO t) {
        return service.add(ColeccionMapper.INSTANCE.toEntity(t));
    }

    @Override
    public boolean update(ColeccionDTO t) throws Exception {
       return service.update(t.idColeccion(), ColeccionMapper.INSTANCE.toEntity(t));
    }

    @Override
    public List<ColeccionDTO> getAll() {
        return service.getAll().stream()
                .map(ColeccionMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public ColeccionDTO getById(int id) {
        return ColeccionMapper.INSTANCE.toDTO(service.getById(id));
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }

   
}
