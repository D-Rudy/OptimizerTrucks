package com.optimizertruck.crudapi.repository;

import com.optimizertruck.crudapi.model.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable,Integer> {
}
