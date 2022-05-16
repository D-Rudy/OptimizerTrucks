package com.optimizertruck.crudapi.controller;

import com.optimizertruck.crudapi.exception.ResourceNotFoundException;

import com.optimizertruck.crudapi.model.Responsable;

import com.optimizertruck.crudapi.repository.ResponsableRepository;
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
public class ResponsableController {

    @Autowired
    private ResponsableRepository responsableRepository;

    @GetMapping("/responsables")
    public List<Responsable> getAllResponsable() {
        return responsableRepository.findAll();
    }

    @GetMapping("/responsable/{id}")
    public ResponseEntity<Responsable> getResponsableById(@PathVariable(value = "id") Integer responsableId) throws ResourceNotFoundException {
        Responsable responsable = responsableRepository.findById(responsableId).orElseThrow(() -> new ResourceNotFoundException("Le responsable avec l'id " + responsableId + " est introuvable"));
        return ResponseEntity.ok().body(responsable);
    }

    @PostMapping("/responsable")
    @ResponseBody
    public ResponseEntity createResponsable(@Valid @RequestBody Responsable responsable) {
        return new ResponseEntity(responsableRepository.save(responsable), HttpStatus.CREATED);
    }

    @PutMapping("/responsable/{id}")
    public ResponseEntity<Responsable> updateResponsable(@PathVariable(value = "id") Integer responsableId,
                                                         @Valid @RequestBody Responsable responsableDetails) throws ResourceNotFoundException {
        Responsable responsable = responsableRepository.findById(responsableId).
                orElseThrow(() -> new ResourceNotFoundException
                        ("Le responsable avec l'id " + responsableId + " est introuvable"));

        responsable.setNomResponsable(responsableDetails.getNomResponsable());
        responsable.setPrenomResponsable(responsableDetails.getPrenomResponsable());
        responsable.setTelResponsable(responsableDetails.getTelResponsable());
        responsable.setMailResponsable(responsableDetails.getMailResponsable());
        responsable.setPasswdResponsable(responsableDetails.getPasswdResponsable());

        final Responsable updatedResponsable = responsableRepository.save(responsable);
        return ResponseEntity.ok(updatedResponsable);
    }

    @DeleteMapping("/responsables/{id}")
    public Map<String, Boolean> deleteResponsable(@PathVariable(value = "id") Integer responsableId) throws ResourceNotFoundException {
        Responsable responsable = responsableRepository.findById(responsableId).orElseThrow(() -> new ResourceNotFoundException("Le responsable avec l'id " + responsableId + " est introuvable"));

        responsableRepository.delete(responsable);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }
}