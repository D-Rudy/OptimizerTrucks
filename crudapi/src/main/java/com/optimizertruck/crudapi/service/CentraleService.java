package com.optimizertruck.crudapi.service;


import com.optimizertruck.crudapi.model.Centrale;
import com.optimizertruck.crudapi.repository.CentraleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CentraleService {

    @Autowired
    CentraleRepository centraleRepository;

    public Iterable<Centrale> getAllCentrales() {
        return centraleRepository.findAll();
    }

    public Optional<Centrale> getCentrale(final String id) {
        return centraleRepository.findById(id);
    }

    public void deleteCentrale(final String id) {
        centraleRepository.deleteById(id);
    }

    public Centrale saveCentrale(Centrale centrale) {
        Centrale savedCentrale = centraleRepository.save(centrale);
        return savedCentrale;
    }

}
