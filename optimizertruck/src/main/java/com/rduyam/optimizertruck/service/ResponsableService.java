package com.rduyam.optimizertruck.service;

import com.rduyam.optimizertruck.model.Responsable;
import com.rduyam.optimizertruck.proxies.ResponsableProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsableService {


    @Autowired
    private ResponsableProxy responsableProxy;

    public Responsable getResponsable(final Long id) {
        return responsableProxy.getResponsable(id);
    }

    public Iterable<Responsable> getAllResponsables() {
        return responsableProxy.getAllResponsables();
    }

    public void deleteResponsable(final Long id) {
        responsableProxy.deleteResponsable(id);
    }

    public Responsable saveResponsable(Responsable responsable) {
        Responsable savedResponsable;

        // Functional rule : Centrale name must be capitalized.
        responsable.setNomResponsable(responsable.getNomResponsable().toUpperCase());

        if (responsable.getIdResponsable() == null) {
            // If id is null, then it is a new centrale
            savedResponsable = responsableProxy.createResponsable(responsable);
        } else {
            savedResponsable = responsableProxy.updateResponsable(responsable);
        }

        return savedResponsable;
    }
}
