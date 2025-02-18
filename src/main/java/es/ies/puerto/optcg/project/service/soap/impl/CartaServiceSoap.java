package es.ies.puerto.optcg.project.service.soap.impl;


import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.ies.puerto.optcg.project.dto.CartaDTO;
import es.ies.puerto.optcg.project.mapper.struct.CartaMapper;
import es.ies.puerto.optcg.project.model.entities.Carta;
import es.ies.puerto.optcg.project.service.interfaces.IService;
import es.ies.puerto.optcg.project.service.interfaces.IServiceSoap;

import java.util.List;
import java.util.stream.Collectors;

@Component
@WebService(endpointInterface = "es.ies.puerto.optcg.project.service.interfaces.IServiceSoap")
public class CartaServiceSoap implements IServiceSoap<CartaDTO> {



    private final IService<Carta> service;

    @Autowired
    public CartaServiceSoap(IService<Carta> service) {
        this.service = service;
    }
    @Override
    public boolean add(CartaDTO t) {
        return service.add(CartaMapper.INSTANCE.toEntity(t));
    }

    @Override
    public boolean update(CartaDTO t) throws Exception {
       return service.update(t.getId(), CartaMapper.INSTANCE.toEntity(t));
    }

    @Override
    public List<CartaDTO> getAll() {
        return service.getAll().stream()
                .map(CartaMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public CartaDTO getById(int id) {
        return CartaMapper.INSTANCE.toDTO(service.getById(id));
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }

   
}
