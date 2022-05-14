package com.optimizertruck.crudapi.repository;

import com.optimizertruck.crudapi.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MissionRepository extends JpaRepository<Mission,Integer> {
}
