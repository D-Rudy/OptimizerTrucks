package com.optimizertruck.crudapi.repository;

import com.optimizertruck.crudapi.model.Livrer;
import com.optimizertruck.crudapi.model.LivrerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrerRepository extends JpaRepository<Livrer, LivrerId> {
}
