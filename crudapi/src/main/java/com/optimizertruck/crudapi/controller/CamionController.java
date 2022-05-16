package com.optimizertruck.crudapi.controller;

import com.optimizertruck.crudapi.exception.ResourceNotFoundException;
import com.optimizertruck.crudapi.model.Camion;
import com.optimizertruck.crudapi.repository.CamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class CamionController {

    @Autowired
    private CamionRepository camionRepository;

    @GetMapping("/camions")
    public List<Camion> getAllCamions() {
        return camionRepository.findAll();
    }

    @GetMapping("/camions/{id}")
    public ResponseEntity<Camion> getCamionById(@PathVariable(value = "id") Integer camionId) throws ResourceNotFoundException {
        Camion camion = camionRepository.findById(camionId).orElseThrow(() -> new ResourceNotFoundException("Le camion avec l'id " + camionId + " est introuvable"));
        return ResponseEntity.ok().body(camion);
    }

    @PostMapping("/camions")
    public Camion createCamion(@Valid @RequestBody Camion camion) {
        return camionRepository.save(camion);
    }

    @PutMapping("/camions/{id}")
    public ResponseEntity<Camion> updateCamion(@PathVariable(value = "id") Integer camionId,
                                               @Valid @RequestBody Camion camionDetails) throws ResourceNotFoundException {
        Camion camion = camionRepository.findById(camionId).
                orElseThrow(() -> new ResourceNotFoundException
                        ("Le camion avec l'id " + camionId + " est introuvable"));
        //camion.setIdCamion(camionDetails.getIdCamion());
        camion.setNettoyage(camionDetails.getNettoyage());
        camion.setVidange(camionDetails.getVidange());
        camion.setRemplissage(camionDetails.getRemplissage());
        final Camion updatedCamion = camionRepository.save(camion);
        return ResponseEntity.ok(updatedCamion);
    }

    @DeleteMapping("/camions/{id}")
    public Map<String, Boolean> deleteCamion(@PathVariable(value = "id") Integer camionId) throws ResourceNotFoundException {
        Camion camion = camionRepository.findById(camionId).orElseThrow(() -> new ResourceNotFoundException("Le camion avec l'id " + camionId + " est introuvable"));

        camionRepository.delete(camion);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }

}
