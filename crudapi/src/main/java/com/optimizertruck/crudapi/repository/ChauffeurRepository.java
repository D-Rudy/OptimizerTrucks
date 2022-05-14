package com.optimizertruck.crudapi.repository;

import com.optimizertruck.crudapi.model.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChauffeurRepository extends JpaRepository<Chauffeur, String> {
}
