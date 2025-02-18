package es.ies.puerto.optcg.project.service.soap.impl;


import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.ies.puerto.optcg.project.dto.ExpansionDTO;
import es.ies.puerto.optcg.project.mapper.struct.ExpansionMapper;
import es.ies.puerto.optcg.project.model.entities.Expansion;
import es.ies.puerto.optcg.project.service.interfaces.IService;
import es.ies.puerto.optcg.project.service.interfaces.IServiceSoap;

import java.util.List;
import java.util.stream.Collectors;

@Component
@WebService(endpointInterface = "es.ies.puerto.optcg.project.service.interfaces.IServiceSoap")
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
       return service.update(t.getId(), ExpansionMapper.INSTANCE.toEntity(t));
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

