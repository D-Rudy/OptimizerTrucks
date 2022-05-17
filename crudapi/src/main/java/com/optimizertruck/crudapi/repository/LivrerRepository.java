package com.optimizertruck.crudapi.repository;

import com.optimizertruck.crudapi.model.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrerRepository extends JpaRepository<Livraison, Long> {
}
