package es.ies.puerto.optcg.project.service.soap.impl;


import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.ies.puerto.optcg.project.dto.ColeccionDTO;
import es.ies.puerto.optcg.project.mapper.struct.ColeccionMapper;
import es.ies.puerto.optcg.project.model.entities.Coleccion;
import es.ies.puerto.optcg.project.service.interfaces.IService;
import es.ies.puerto.optcg.project.service.interfaces.IServiceSoap;

import java.util.List;
import java.util.stream.Collectors;

@Component
@WebService(endpointInterface = "es.ies.puerto.optcg.project.service.interfaces.IServiceSoap")
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
       return service.update(t.getId(), ColeccionMapper.INSTANCE.toEntity(t));
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
