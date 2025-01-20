package es.system.danileonpe.springboot.soap.service;

import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Expansion;
import es.system.danileonpe.springboot.service.ExpansionServiceInterface;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(endpointInterface = "es.system.danileonpe.springboot.soap.service.ExpansionServiceSoapInterface")
public class ExpansionServiceSoap implements ExpansionServiceSoapInterface {

    @Autowired
    private ExpansionServiceInterface expansionService;

    @Override
    public List<Expansion> getAllExpansions() {
        return expansionService.getAllExpansion();
    }

    @Override
    public Expansion getExpansionById(int expansionId) throws ResourceNotFoundException {
        return expansionService.getExpansionById(expansionId);
    }

    @Override
    public Expansion addExpansion(Expansion expansion) {
        return expansionService.createExpansion(expansion);
    }

    @Override
    public Expansion updateExpansion(int expansionId, Expansion expansion) throws ResourceNotFoundException {
        return expansionService.updateExpansion(expansionId, expansion);
    }

    @Override
    public boolean deleteExpansion(int expansionId) throws ResourceNotFoundException {
        return expansionService.deleteExpansion(expansionId);
    }
}

