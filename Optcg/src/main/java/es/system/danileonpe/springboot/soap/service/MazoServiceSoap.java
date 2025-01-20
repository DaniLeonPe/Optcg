package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Mazo;
import es.system.danileonpe.springboot.service.MazoServiceInterface;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(endpointInterface = "es.system.danileonpe.springboot.soap.service.MazoServiceSoapInterface")
public class MazoServiceSoap implements MazoServiceSoapInterface {

    @Autowired
    private MazoServiceInterface mazoService;

    @Override
    public List<Mazo> getAllMazos() {

        return mazoService.getAllMazo();
    }

    @Override
    public Mazo getMazoById(int mazoId) throws ResourceNotFoundException {

        return mazoService.getMazoById(mazoId);
    }

    @Override
    public Mazo addMazo(Mazo mazo) {

        return mazoService.createMazo(mazo);
    }

    @Override
    public Mazo updateMazo(int mazoId, Mazo mazo) throws ResourceNotFoundException {

        return mazoService.updateMazo(mazoId, mazo);
    }

    @Override
    public boolean deleteMazo(int mazoId) throws ResourceNotFoundException {

        return mazoService.deleteMazo(mazoId);
    }
}
