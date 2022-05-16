package com.optimizertruck.crudapi.controller;


import com.optimizertruck.crudapi.exception.ResourceNotFoundException;
import com.optimizertruck.crudapi.model.Chantier;
import com.optimizertruck.crudapi.repository.ChantierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ChantierController {
    @Autowired
    private ChantierRepository chantierRepository;

    @GetMapping("/chantiers")
    public List<Chantier> getAllChantier() {
        return chantierRepository.findAll();
    }

    @GetMapping("/chantiers/{id}")
    public ResponseEntity<Chantier> getChantierById(@PathVariable(value = "id") Integer chantierId) throws ResourceNotFoundException {
        Chantier chantier = chantierRepository.findById(chantierId).orElseThrow(() -> new ResourceNotFoundException("Le chantier avec l'id " + chantierId + " est introuvable"));
        return ResponseEntity.ok().body(chantier);
    }

    @PostMapping("/chantiers")
    public Chantier createChantier(@Valid @RequestBody Chantier chantier) {
        return chantierRepository.save(chantier);
    }

    @PutMapping("/chantiers/{id}")
    public ResponseEntity<Chantier> updateChantier(@PathVariable(value = "id") Integer chantierId,
                                                   @Valid @RequestBody Chantier chantierDetails) throws ResourceNotFoundException {
        Chantier chantier = chantierRepository.findById(chantierId).
                orElseThrow(() -> new ResourceNotFoundException
                        ("Le chantier avec l'id " + chantierId + " est introuvable"));
        // chantier.setIdChantier(chantierDetails.getIdChantier());
        chantier.setNomChantier(chantierDetails.getNomChantier());
        chantier.setAdresseChantier(chantierDetails.getAdresseChantier());
        chantier.setCpChantier(chantierDetails.getCpChantier());
        chantier.setVilleChantier(chantierDetails.getVilleChantier());
        chantier.setCoordonneeChantier(chantierDetails.getCoordonneeChantier());
        chantier.setLivraisons(chantier.getLivraisons());
        final Chantier updatedChantier = chantierRepository.save(chantier);
        return ResponseEntity.ok(updatedChantier);
    }

    @DeleteMapping("/chantiers/{id}")
    public Map<String, Boolean> deleteChantier(@PathVariable(value = "id") Integer chantierId) throws ResourceNotFoundException {
        Chantier chantier = chantierRepository.findById(chantierId).orElseThrow(() -> new ResourceNotFoundException("Le chantier avec l'id " + chantierId + " est introuvable"));

        chantierRepository.delete(chantier);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }

}
