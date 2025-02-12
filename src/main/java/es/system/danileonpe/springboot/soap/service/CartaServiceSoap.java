package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.DTO.CartaDTO;
import es.system.danileonpe.springboot.mapper.CartaMapper;
import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.service.interfaces.IService;
import es.system.danileonpe.springboot.service.interfaces.IServiceSoap;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@WebService(endpointInterface = "es.system.danileonpe.springboot.service.interfaces.IServiceSoap")
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
       return service.update(t.id(), CartaMapper.INSTANCE.toEntity(t));
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
