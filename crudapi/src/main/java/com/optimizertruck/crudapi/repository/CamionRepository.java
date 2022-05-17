package com.optimizertruck.crudapi.repository;

import com.optimizertruck.crudapi.model.Camion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamionRepository extends JpaRepository<Camion, Long> {
}
