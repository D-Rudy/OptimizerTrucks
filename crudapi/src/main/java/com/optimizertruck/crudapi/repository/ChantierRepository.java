package com.optimizertruck.crudapi.repository;

import com.optimizertruck.crudapi.model.Chantier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChantierRepository extends JpaRepository<Chantier, Long> {
}
