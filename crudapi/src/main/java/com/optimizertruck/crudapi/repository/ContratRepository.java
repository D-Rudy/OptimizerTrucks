package com.optimizertruck.crudapi.repository;

import com.optimizertruck.crudapi.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {
}
