package com.optimizertruck.crudapi.repository;

import com.optimizertruck.crudapi.model.Chauffeur;
import com.optimizertruck.crudapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository  extends JpaRepository<Client, String> {
}
