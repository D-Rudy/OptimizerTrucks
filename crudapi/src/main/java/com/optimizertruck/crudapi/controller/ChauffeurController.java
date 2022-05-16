package com.optimizertruck.crudapi.controller;

import com.optimizertruck.crudapi.exception.ResourceNotFoundException;
import com.optimizertruck.crudapi.model.Chauffeur;
import com.optimizertruck.crudapi.repository.ChauffeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class ChauffeurController {


    @Autowired
    private ChauffeurRepository chauffeurRepository;

    @GetMapping("/chauffeurs")
    public List<Chauffeur> getAllChauffeurs() {
        return chauffeurRepository.findAll();
    }

    @GetMapping("/chauffeur/{id}")
    public ResponseEntity<Chauffeur> getChauffeurById(@PathVariable(value = "id") Integer chauffeurId) throws ResourceNotFoundException {
        Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId).orElseThrow(() -> new ResourceNotFoundException("Le Chauffeur avec l'id " + chauffeurId + " est introuvable"));
        return ResponseEntity.ok().body(chauffeur);
    }

    @PostMapping("/chauffeur")
    public Chauffeur createChauffeur(@Valid @RequestBody Chauffeur chauffeur) {
        return chauffeurRepository.save(chauffeur);
    }

    @PutMapping("/chauffeur/{id}")
    public ResponseEntity<Chauffeur> updateChauffeur(@PathVariable(value = "id") Integer chauffeurId,
                                                   @Valid @RequestBody Chauffeur chauffeurDetails) throws ResourceNotFoundException {
        Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId).
                orElseThrow(() -> new ResourceNotFoundException
                        ("Le Chauffeur avec l'id " + chauffeurId + " est introuvable"));
        //chauffeur.setId(chauffeurDetails.getId());
        chauffeur.setNomChauffeur(chauffeurDetails.getNomChauffeur());
        chauffeur.setPrenomChauffeur(chauffeurDetails.getPrenomChauffeur());
        chauffeur.setTelChauffeur(chauffeurDetails.getTelChauffeur());
        chauffeur.setMailChauffeur(chauffeurDetails.getMailChauffeur());
        chauffeur.setPasswdChauffeur(chauffeurDetails.getPasswdChauffeur());
        //chauffeur.setCamion(chauffeurDetails.getCamion());
        final Chauffeur updatedChauffeur = chauffeurRepository.save(chauffeur);
        return ResponseEntity.ok(updatedChauffeur);
    }

    @DeleteMapping("/chauffeurs/{id}")
    public Map<String, Boolean> deleteChauffeur(@PathVariable(value = "id") Integer chauffeurId) throws ResourceNotFoundException {
        Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId).orElseThrow(() -> new ResourceNotFoundException("Le Chauffeur avec l'id " + chauffeurId + " est introuvable"));

        chauffeurRepository.delete(chauffeur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }
}
