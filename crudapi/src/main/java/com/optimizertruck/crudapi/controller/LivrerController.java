package com.optimizertruck.crudapi.controller;


import com.optimizertruck.crudapi.exception.ResourceNotFoundException;

import com.optimizertruck.crudapi.model.Livraison;
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
    public List<Livraison> getAllLivraisons() {
        return livrerRepository.findAll();
    }

    @GetMapping("/livraisons/{id}")
    public ResponseEntity<Livraison> getLogisticienById(@PathVariable(value = "id") Integer livraisonId) throws ResourceNotFoundException {
        Livraison livraison = livrerRepository.findById(livraisonId).orElseThrow(() -> new ResourceNotFoundException("La livraison avec l'id " + livraisonId + " est introuvable"));
        return ResponseEntity.ok().body(livraison);
    }

    @PostMapping("/livraisons")
    public Livraison createLivraison(@Valid @RequestBody Livraison livraison) {
        return livrerRepository.save(livraison);
    }

    @PutMapping("/livraisons/{id}")
    public ResponseEntity<Livraison> updateLivraison(@PathVariable(value = "id") Integer livraisonId,
                                                  @Valid @RequestBody Livraison livraisonDetails) throws ResourceNotFoundException {
        Livraison livraison = livrerRepository.findById(livraisonId).
                orElseThrow(() -> new ResourceNotFoundException
                        ("La livraison avec l'id " + livraisonId + " est introuvable"));

        livraison.setId(livraisonDetails.getId());
        livraison.setCamion(livraisonDetails.getCamion());
        livraison.setChantier(livraisonDetails.getChantier());
        livraison.setQteLivree(livraisonDetails.getQteLivree());
        livraison.setNbTour(livraisonDetails.getNbTour());

        final Livraison updatedLivraison = livrerRepository.save(livraison);
        return ResponseEntity.ok(updatedLivraison);
    }

    @DeleteMapping("/livraisons/{id}")
    public Map<String, Boolean> deleteLivraison(@PathVariable(value = "id") Integer livraisonId) throws ResourceNotFoundException {
        Livraison livraison = livrerRepository.findById(livraisonId).orElseThrow(() -> new ResourceNotFoundException("La livraison avec l'id " + livraisonId + " est introuvable"));

        livrerRepository.delete(livraison);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }
}
