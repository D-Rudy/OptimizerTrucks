package com.rduyam.optimizertruck.service;

import com.rduyam.optimizertruck.model.Logisticien;
import com.rduyam.optimizertruck.proxies.LogisticienProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogisticienService {
    @Autowired
    private LogisticienProxy logisticienProxy;

    public Logisticien getLogisticien(final Long id) {
        return logisticienProxy.getLogisticien(id);
    }

    public Iterable<Logisticien> getAllLogisticiens() {
        return logisticienProxy.getAllLogisticiens();
    }

    public void deleteLogisticien(final Long id) {
        logisticienProxy.deleteLogisticien(id);
    }

    public Logisticien saveLogisticien(Logisticien logisticien) {
        Logisticien savedLogisticien;

        // Functional rule : Logisticien name must be capitalized.
        logisticien.setNomLogisticien(logisticien.getNomLogisticien().toUpperCase());

        if (logisticien.getIdLogisticien() == null) {
            // If id is null, then it is a new Logisticien
            savedLogisticien = logisticienProxy.createLogisticien(logisticien);
        } else {
            savedLogisticien = logisticienProxy.updateLogisticien(logisticien);
        }

        return savedLogisticien;
    }
}
