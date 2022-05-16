
package com.rduyam.optimizertruck.service;


import com.rduyam.optimizertruck.model.Centrale;
import com.rduyam.optimizertruck.proxies.CentraleProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentraleService {

    @Autowired
    private CentraleProxy centraleProxy;

    public Centrale getCentrale(final Long id) {
        return centraleProxy.getCentrale(id);
    }

    public Iterable<Centrale> getAllCentrales() {
        return centraleProxy.getAllCentrales();
    }

    public void deleteCentrale(final Long id) {
        centraleProxy.deleteCentrale(id);
    }

    public Centrale saveCentrale(Centrale centrale) {
        Centrale savedCentrale;

        // Functional rule : Last name must be capitalized.
        centrale.setNomCentrale(centrale.getNomCentrale().toUpperCase());

       if (centrale.getIdCentrale() == null) {
            // If id is null, then it is a new centrale
           savedCentrale = centraleProxy.createCentrale(centrale);
        } else {
            savedCentrale = centraleProxy.updateCentrale(centrale);
        }

        return savedCentrale;
    }
}

