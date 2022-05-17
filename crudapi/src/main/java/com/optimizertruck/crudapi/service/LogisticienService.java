package com.optimizertruck.crudapi.service;


import com.optimizertruck.crudapi.model.Logisticien;
import com.optimizertruck.crudapi.repository.LogisticienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogisticienService {


    @Autowired
    LogisticienRepository logisticienRepository;



    public Iterable<Logisticien> Logisticien() {
        return logisticienRepository.findAll();
    }

    public Optional<Logisticien> getLogisticien(final Long id) {
        return logisticienRepository.findById(id);
    }

    public void deleteLogisticien(final Long id) {
        logisticienRepository.deleteById(id);
    }

    public Logisticien saveLogisticien(Logisticien logisticien) {
        Logisticien savedLogisticien = logisticienRepository.save(logisticien);
        return savedLogisticien;
    }
}
