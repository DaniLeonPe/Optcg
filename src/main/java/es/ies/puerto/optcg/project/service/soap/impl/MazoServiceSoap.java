package es.ies.puerto.optcg.project.service.soap.impl;


import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.ies.puerto.optcg.project.dto.MazoDTO;
import es.ies.puerto.optcg.project.mapper.struct.MazoMapper;
import es.ies.puerto.optcg.project.model.entities.Mazo;
import es.ies.puerto.optcg.project.service.interfaces.IService;
import es.ies.puerto.optcg.project.service.interfaces.IServiceSoap;

import java.util.List;
import java.util.stream.Collectors;

@Component
@WebService(endpointInterface = "es.ies.puerto.optcg.project.service.interfaces.IServiceSoap")
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
       return service.update(t.getId(), MazoMapper.INSTANCE.toEntity(t));
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
