package com.optimizertruck.crudapi.controller;


import com.optimizertruck.crudapi.exception.ResourceNotFoundException;
import com.optimizertruck.crudapi.model.Client;
import com.optimizertruck.crudapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ClientController {


    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Integer clientId) throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("Le client avec l'id " + clientId + " est introuvable"));
        return ResponseEntity.ok().body(client);
    }

    @PostMapping("/clients")
    public Client createClient(@Valid @RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Integer clientId,
                                               @Valid @RequestBody Client clientDetails) throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientId).
                orElseThrow(() -> new ResourceNotFoundException
                        ("Le client avec l'id " + clientId + " est introuvable"));
        //client.setId(clientDetails.getId());
        client.setNomClient(clientDetails.getNomClient());
        client.setPrenomClient(clientDetails.getPrenomClient());
        client.setTelClient(clientDetails.getTelClient());
        client.setMailClient(clientDetails.getMailClient());
        client.setAdresseClient(clientDetails.getAdresseClient());
        client.setCpClient(clientDetails.getCpClient());
        client.setVilleClient(clientDetails.getVilleClient());
        final Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/clients/{id}")
    public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Integer clientId) throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException ("Le client avec l'id " + clientId + " est introuvable"));

        clientRepository.delete(client);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }

}
