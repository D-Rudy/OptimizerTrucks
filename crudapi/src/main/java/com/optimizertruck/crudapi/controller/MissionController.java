package com.optimizertruck.crudapi.controller;

import com.optimizertruck.crudapi.exception.ResourceNotFoundException;
import com.optimizertruck.crudapi.model.Mission;
import com.optimizertruck.crudapi.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MissionController {
    @Autowired
    private MissionRepository missionRepository;

    @GetMapping("/missions")
    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

    @GetMapping("/missions/{id}")
    public ResponseEntity<Mission> getMissionById(@PathVariable(value = "id") Integer missionId) throws ResourceNotFoundException {
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new ResourceNotFoundException("La mission avec l'id " + missionId + " est introuvable"));
        return ResponseEntity.ok().body(mission);
    }

    @PostMapping("/missions")
    public Mission createMission(@Valid @RequestBody Mission mission) {
        return missionRepository.save(mission);
    }

    @PutMapping("/missions/{id}")
    public ResponseEntity<Mission> updateMission(@PathVariable(value = "id") Integer missionId,
                                                 @Valid @RequestBody Mission missionDetails) throws ResourceNotFoundException {
        Mission mission = missionRepository.findById(missionId).
                orElseThrow(() -> new ResourceNotFoundException
                        ("La mission avec l'id " + missionId + " est introuvable"));
        mission.setId(missionDetails.getId());
        mission.setDateHeure(missionDetails.getDateHeure());
        mission.setQteATransporter(missionDetails.getQteATransporter());
        mission.setAccepterMission(missionDetails.getAccepterMission());
        mission.setLogisticien(missionDetails.getLogisticien());
        mission.setChauffeur(missionDetails.getChauffeur());
        mission.setLogisticien(missionDetails.getLogisticien());
        final Mission updatedClient = missionRepository.save(mission);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/missions/{id}")
    public Map<String, Boolean> deleteMission(@PathVariable(value = "id") Integer missionId) throws ResourceNotFoundException {
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new ResourceNotFoundException("La mission avec l'id " + missionId + " est introuvable"));

        missionRepository.delete(mission);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }
}
