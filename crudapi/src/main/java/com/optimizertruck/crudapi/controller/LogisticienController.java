package com.optimizertruck.crudapi.controller;


import com.optimizertruck.crudapi.exception.ResourceNotFoundException;
import com.optimizertruck.crudapi.model.Logisticien;
import com.optimizertruck.crudapi.repository.LogisticienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class LogisticienController {

    @Autowired
    private LogisticienRepository logisticienRepository;

    @GetMapping("/logisticiens")
    public List<Logisticien> getAllLogisticiens() {
        return logisticienRepository.findAll();
    }

    @GetMapping("/logisticiens/{id}")
    public ResponseEntity<Logisticien> getLogisticienById(@PathVariable(value = "id") Integer logisticienId) throws ResourceNotFoundException {
        Logisticien logisticien = logisticienRepository.findById(logisticienId).orElseThrow(() -> new ResourceNotFoundException("Le logisticien avec l'id " + logisticienId + " est introuvable"));
        return ResponseEntity.ok().body(logisticien);
    }

    @PostMapping("/logisticiens")
    public Logisticien createLogisticien(@Valid @RequestBody Logisticien logisticien) {
        return logisticienRepository.save(logisticien);
    }

    @PutMapping("/logisticiens/{id}")
    public ResponseEntity<Logisticien> updateLogisticien(@PathVariable(value = "id") Integer logisticienId,
                                                   @Valid @RequestBody Logisticien logisticienDetails) throws ResourceNotFoundException {
        Logisticien logisticien = logisticienRepository.findById(logisticienId).
                orElseThrow(() -> new ResourceNotFoundException
                        ("Le logisticien avec l'id " + logisticienId + " est introuvable"));

        logisticien.setNom(logisticienDetails.getNom());
        logisticien.setPrenom(logisticienDetails.getPrenom());
        logisticien.setTel(logisticienDetails.getTel());
        logisticien.setMail(logisticienDetails.getMail());
        logisticien.setPasswd(logisticienDetails.getPasswd());

        final Logisticien updatedLogisticien = logisticienRepository.save(logisticien);
        return ResponseEntity.ok(updatedLogisticien);
    }

    @DeleteMapping("/logisticiens/{id}")
    public Map<String, Boolean> deleteLogisticien(@PathVariable(value = "id") Integer logisticienId) throws ResourceNotFoundException {
        Logisticien centrale = logisticienRepository.findById(logisticienId).orElseThrow(() -> new ResourceNotFoundException("Le logisticien avec l'id " + logisticienId + " est introuvable"));

        logisticienRepository.delete(centrale);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }
}
