package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.DTO.MazoDTO;
import es.system.danileonpe.springboot.mapper.MazoMapper;
import es.system.danileonpe.springboot.model.Mazo;
import es.system.danileonpe.springboot.service.interfaces.IService;
import es.system.danileonpe.springboot.service.interfaces.IServiceSoap;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@WebService(endpointInterface = "es.system.danileonpe.springboot.service.interfaces.IServiceSoap")
public class MazoServiceSoap implements IServiceSoap<MazoDTO> {

    private final IService<Mazo> service;

    @Autowired
    public MazoServiceSoap(IService<Mazo> service) {
        this.service = service;
    }

    @Override
    public boolean add(MazoDTO t) {
        return service.add(MazoMapper.INSTANCE.toEntity(t));
    }

    @Override
    public boolean update(MazoDTO t) throws Exception {
       return service.update(t.idMazo(), MazoMapper.INSTANCE.toEntity(t));
    }

    @Override
    public List<MazoDTO> getAll() {
        return service.getAll().stream()
                .map(MazoMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public MazoDTO getById(int id) {
        return MazoMapper.INSTANCE.toDTO(service.getById(id));
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }

}
