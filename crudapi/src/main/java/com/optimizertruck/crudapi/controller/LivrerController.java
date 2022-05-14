package com.optimizertruck.crudapi.controller;


import com.optimizertruck.crudapi.exception.ResourceNotFoundException;

import com.optimizertruck.crudapi.model.Livrer;
import com.optimizertruck.crudapi.model.LivrerId;
import com.optimizertruck.crudapi.repository.LivrerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class LivrerController {


    @Autowired
    private LivrerRepository livrerRepository;

    @GetMapping("/livraisons")
    public List<Livrer> getAllLivraisons() {
        return livrerRepository.findAll();
    }

    @GetMapping("/livraisons/{id}")
    public ResponseEntity<Livrer> getLogisticienById(@PathVariable(value = "id") LivrerId livraisonId) throws ResourceNotFoundException {
        Livrer livraison = livrerRepository.findById(livraisonId).orElseThrow(() -> new ResourceNotFoundException("La livraison avec l'id " + livraisonId + " est introuvable"));
        return ResponseEntity.ok().body(livraison);
    }

    @PostMapping("/livraisons")
    public Livrer createLivraison(@Valid @RequestBody Livrer livraison) {
        return livrerRepository.save(livraison);
    }

    @PutMapping("/livraisons/{id}")
    public ResponseEntity<Livrer> updateLivraison(@PathVariable(value = "id") LivrerId livraisonId,
                                                  @Valid @RequestBody Livrer livraisonDetails) throws ResourceNotFoundException {
        Livrer livraison = livrerRepository.findById(livraisonId).
                orElseThrow(() -> new ResourceNotFoundException
                        ("La livraison avec l'id " + livraisonId + " est introuvable"));

        livraison.setLivrerId(livraisonDetails.getLivrerId());
        livraison.setCamion(livraisonDetails.getCamion());
        livraison.setChantier(livraisonDetails.getChantier());
        livraison.setQteLivree(livraisonDetails.getQteLivree());
        livraison.setNbTour(livraisonDetails.getNbTour());

        final Livrer updatedLivraison = livrerRepository.save(livraison);
        return ResponseEntity.ok(updatedLivraison);
    }

    @DeleteMapping("/livraisons/{id}")
    public Map<String, Boolean> deleteLivraison(@PathVariable(value = "id") LivrerId livraisonId) throws ResourceNotFoundException {
        Livrer livraison = livrerRepository.findById(livraisonId).orElseThrow(() -> new ResourceNotFoundException("La livraison avec l'id " + livraisonId + " est introuvable"));

        livrerRepository.delete(livraison);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }
}
