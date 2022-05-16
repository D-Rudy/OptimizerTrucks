package com.optimizertruck.crudapi.controller;

import com.optimizertruck.crudapi.exception.ResourceNotFoundException;
import com.optimizertruck.crudapi.model.Centrale;
import com.optimizertruck.crudapi.service.CentraleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CentraleController {

    @Autowired
    private CentraleService centraleService;

    @GetMapping("/centrales")
    public Iterable<Centrale> getAllCentrales() {
        return centraleService.getAllCentrales();
    }

    @GetMapping("/centrale/{id}")
    public ResponseEntity<Centrale> getCentraleById(@PathVariable(value = "id") Long centraleId) throws ResourceNotFoundException {
        Centrale centrale = centraleService.getCentrale(centraleId).orElseThrow(() -> new ResourceNotFoundException("Centrale avec l'id " + centraleId + " est introuvable"));
        return ResponseEntity.ok().body(centrale);
    }

    @PostMapping("/centrale")
    public ResponseEntity createCentrale(@RequestBody Centrale centrale) {
        return new ResponseEntity(centraleService.saveCentrale(centrale), HttpStatus.CREATED);
    }

    @PutMapping("/centrale/{id}")
    public ResponseEntity<Centrale> updateCentrale(@PathVariable(value = "id") Long centraleId,
                                                   @Valid @RequestBody Centrale centraleDetails) throws ResourceNotFoundException {
        Centrale centrale = centraleService.getCentrale(centraleId).
                orElseThrow(() -> new ResourceNotFoundException
                        ("Centrale avec l'id " + centraleId + " est introuvable"));
       // centrale.setIdCentrale(centraleDetails.getIdCentrale());
        centrale.setNomCentrale(centraleDetails.getNomCentrale());
        centrale.setTelCentrale(centraleDetails.getTelCentrale());
        centrale.setAdresseCentrale(centraleDetails.getAdresseCentrale());
        centrale.setCpCentrale(centraleDetails.getCpCentrale());
        centrale.setVilleCentrale(centraleDetails.getVilleCentrale());
        centrale.setCoordonneCentrale(centraleDetails.getCoordonneCentrale());
        centrale.setCapaciteProd(centraleDetails.getCapaciteProd());
        final Centrale updatedCentrale = centraleService.saveCentrale(centrale);
        return ResponseEntity.ok(updatedCentrale);
    }

    @DeleteMapping("/centrale/{id}")
    public Map<String, Boolean> deleteCentrale(@PathVariable(value = "id") Long centraleId) throws ResourceNotFoundException {
        Centrale centrale = centraleService.getCentrale(centraleId).orElseThrow(() -> new ResourceNotFoundException("Centrale avec l'id " + centraleId + " est introuvable"));

        centraleService.deleteCentrale(centraleId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }
}
