package com.optimizertruck.crudapi.controller;

import com.optimizertruck.crudapi.exception.ResourceNotFoundException;
import com.optimizertruck.crudapi.model.Contrat;
import com.optimizertruck.crudapi.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ContratController {

    @Autowired
    private ContratRepository contratRepository;

    @GetMapping("/contrats")
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @GetMapping("/contrat/{id}")
    public ResponseEntity<Contrat> getContratById(@PathVariable(value = "id") Long contratId) throws ResourceNotFoundException {
        Contrat contrat = contratRepository.findById(contratId).orElseThrow(() -> new ResourceNotFoundException("Le contrat avec l'id " + contratId + " est introuvable"));
        return ResponseEntity.ok().body(contrat);
    }

    @PostMapping("/contrat")
    public ResponseEntity createContrat(@Valid @RequestBody Contrat contrat) {
        return new ResponseEntity(contratRepository.save(contrat), HttpStatus.CREATED);
    }

    @PutMapping("/contrat/{id}")
    public ResponseEntity<Contrat> updateContrat(@PathVariable(value = "id") Long contratId,
                                                 @Valid @RequestBody Contrat contratDetails) throws ResourceNotFoundException {
        Contrat contrat = contratRepository.findById(contratId).
                orElseThrow(() -> new ResourceNotFoundException
                        ("Le contrat avec l'id " + contratId + " est introuvable"));
        //contrat.setId(contratDetails.getId());
        contrat.setDateDebutContrat(contratDetails.getDateDebutContrat());
        contrat.setDateFinContrat(contratDetails.getDateFinContrat());
        contrat.setQteALivrerContrat(contratDetails.getQteALivrerContrat());
        contrat.setClient(contratDetails.getClient());
        contrat.setChantier(contratDetails.getChantier());
        contrat.setClient(contratDetails.getClient());
        final Contrat updatedContrat = contratRepository.save(contrat);
        return ResponseEntity.ok(updatedContrat);
    }

    @DeleteMapping("/contrat/{id}")
    public Map<String, Boolean> deleteContrat(@PathVariable(value = "id") Long contratId) throws ResourceNotFoundException {
        Contrat contrat = contratRepository.findById(contratId).orElseThrow(() -> new ResourceNotFoundException("Le contrat avec l'id " + contratId + " est introuvable"));

        contratRepository.delete(contrat);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }
}
