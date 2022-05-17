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
public class MissionController {
    @Autowired
    private MissionRepository missionRepository;

    @GetMapping("/missions")
    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

    @GetMapping("/mission/{id}")
    public ResponseEntity<Mission> getMissionById(@PathVariable(value = "id") Long missionId) throws ResourceNotFoundException {
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new ResourceNotFoundException("La mission avec l'id " + missionId + " est introuvable"));
        return ResponseEntity.ok().body(mission);
    }

    @PostMapping("/mission")
    public Mission createMission(@Valid @RequestBody Mission mission) {
        return missionRepository.save(mission);
    }

    @PutMapping("/mission/{id}")
    public ResponseEntity<Mission> updateMission(@PathVariable(value = "id") Long missionId,
                                                 @Valid @RequestBody Mission missionDetails) throws ResourceNotFoundException {
        Mission mission = missionRepository.findById(missionId).
                orElseThrow(() -> new ResourceNotFoundException
                        ("La mission avec l'id " + missionId + " est introuvable"));
        //mission.setId(missionDetails.getId());
        mission.setDateHeureMission(missionDetails.getDateHeureMission());
        mission.setQteATransporterMission(missionDetails.getQteATransporterMission());
        mission.setAccepterMission(missionDetails.getAccepterMission());
        mission.setLogisticien(missionDetails.getLogisticien());
        mission.setChauffeur(missionDetails.getChauffeur());
        mission.setLogisticien(missionDetails.getLogisticien());
        final Mission updatedClient = missionRepository.save(mission);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/mission/{id}")
    public Map<String, Boolean> deleteMission(@PathVariable(value = "id") Long missionId) throws ResourceNotFoundException {
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new ResourceNotFoundException("La mission avec l'id " + missionId + " est introuvable"));

        missionRepository.delete(mission);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }
}
