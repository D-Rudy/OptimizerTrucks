package com.rduyam.optimizertruck.service;


import com.rduyam.optimizertruck.model.Centrale;
import com.rduyam.optimizertruck.proxies.CentraleProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentraleService {

    @Autowired
    private CentraleProxy centraleProxy;

    public Centrale getCentrale(final String id) {
        return centraleProxy.getCentrale(id);
    }

    public Iterable<Centrale> getAllCentrales() {
        return centraleProxy.getAllCentrales();
    }

    public void deleteCentrale(final String id) {
        centraleProxy.deleteCentrale(id);
    }

    public Centrale saveEmployee(Centrale centrale) {
        Centrale savedCentrale;

        // Functional rule : Last name must be capitalized.
        centrale.setNom(centrale.getNom().toUpperCase());

        if (centrale.getId() == null) {
            // If id is null, then it is a new employee.
            savedCentrale = centraleProxy.createEmployee(centrale);
        } else {
            savedCentrale = centraleProxy.updateCentrale(centrale);
        }

        return savedCentrale;
    }
}
