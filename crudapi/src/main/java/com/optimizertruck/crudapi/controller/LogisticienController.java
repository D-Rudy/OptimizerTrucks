package com.optimizertruck.crudapi.controller;


import com.optimizertruck.crudapi.exception.ResourceNotFoundException;
import com.optimizertruck.crudapi.model.Logisticien;
import com.optimizertruck.crudapi.model.Responsable;
import com.optimizertruck.crudapi.repository.LogisticienRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<Logisticien> getAllLogisticien() {
        return logisticienRepository.findAll();
    }

    @GetMapping("/logisticiens/{id}")
    public ResponseEntity<Logisticien> getLogisticienById(@PathVariable(value = "id") String logisticienId) throws ResourceNotFoundException {
        Logisticien logisticien = logisticienRepository.findById(logisticienId).orElseThrow(() -> new ResourceNotFoundException("Le logisticien avec l'id " + logisticienId + " est introuvable"));
        return ResponseEntity.ok().body(logisticien);
    }

    @PostMapping("/logisticiens")
    @ResponseBody
    public ResponseEntity createLogisticien(@Valid @RequestBody Logisticien logisticien) {
        return new ResponseEntity(logisticienRepository.save(logisticien), HttpStatus.CREATED);
    }

    @PutMapping("/logisticiens/{id}")
    public ResponseEntity<Logisticien> updateLogisticien(@PathVariable(value = "id") String logisticienId,
                                                         @Valid @RequestBody Logisticien logisticienDetails) throws ResourceNotFoundException {
        Logisticien logisticien = logisticienRepository.findById(logisticienId).
                orElseThrow(() -> new ResourceNotFoundException
                        ("Le logisticien avec l'id " + logisticienId + " est introuvable"));

        logisticien.setNom(logisticienDetails.getNom());
        logisticien.setPrenom(logisticienDetails.getPrenom());
        logisticien.setTel(logisticienDetails.getTel());
        logisticien.setMail(logisticienDetails.getMail());
        logisticien.setPasswd(logisticienDetails.getPasswd());
        logisticien.setResponsable(logisticienDetails.getResponsable());

        final Logisticien updatedLogisticien = logisticienRepository.save(logisticien);
        return ResponseEntity.ok(updatedLogisticien);
    }

    @DeleteMapping("/logisticiens/{id}")
    public Map<String, Boolean> deleteLogisticien(@PathVariable(value = "id") String logisticienId) throws ResourceNotFoundException {
        Logisticien logisticien = logisticienRepository.findById(logisticienId).orElseThrow(() -> new ResourceNotFoundException("Le logisticien avec l'id " + logisticienId + " est introuvable"));

        logisticienRepository.delete(logisticien);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }
/*     @Autowired
    private LogisticienService logisticienService;

   public LogisticienController(LogisticienService logisticienService) {

        this.logisticienService = logisticienService;
    }

    @GetMapping(path = "/logisticiens/{id}")
    public Logisticien getLogisticien(@PathVariable("id") String matricule) {
        return logisticienService.getLogisticien(matricule);
    }*/
}

