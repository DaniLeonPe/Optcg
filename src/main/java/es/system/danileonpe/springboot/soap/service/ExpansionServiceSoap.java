package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.DTO.ExpansionDTO;
import es.system.danileonpe.springboot.mapper.ExpansionMapper;
import es.system.danileonpe.springboot.model.Expansion;
import es.system.danileonpe.springboot.service.interfaces.IService;
import es.system.danileonpe.springboot.service.interfaces.IServiceSoap;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@WebService(endpointInterface = "es.system.danileonpe.springboot.service.interfaces.IServiceSoap")
public class ExpansionServiceSoap implements IServiceSoap<ExpansionDTO> {

    private final IService<Expansion> service;

    @Autowired
    public ExpansionServiceSoap(IService<Expansion> service) {
        this.service = service;
    }

    @Override
    public boolean add(ExpansionDTO t) {
        return service.add(ExpansionMapper.INSTANCE.toEntity(t));
    }

    @Override
    public boolean update(ExpansionDTO t) throws Exception {
       return service.update(t.idExpansion(), ExpansionMapper.INSTANCE.toEntity(t));
    }

    @Override
    public List<ExpansionDTO> getAll() {
        return service.getAll().stream()
                .map(ExpansionMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public ExpansionDTO getById(int id) {
        return ExpansionMapper.INSTANCE.toDTO(service.getById(id));
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}

