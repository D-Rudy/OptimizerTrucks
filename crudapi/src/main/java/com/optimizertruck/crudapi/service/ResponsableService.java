package com.optimizertruck.crudapi.service;

import com.optimizertruck.crudapi.model.Centrale;
import com.optimizertruck.crudapi.model.Responsable;
import com.optimizertruck.crudapi.repository.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ResponsableService {


    @Autowired
    ResponsableRepository responsableRepository;



    public Iterable<Responsable> getAllResponsables() {
        return responsableRepository.findAll();
    }

    public Optional<Responsable> getResponsable(final Long id) {
        return responsableRepository.findById(id);
    }

    public void deleteResponsable(final Long id) {
        responsableRepository.deleteById(id);
    }

    public Responsable saveResponsable(Responsable responsable) {
        Responsable savedResponsable = responsableRepository.save(responsable);
        return savedResponsable;
    }
}
