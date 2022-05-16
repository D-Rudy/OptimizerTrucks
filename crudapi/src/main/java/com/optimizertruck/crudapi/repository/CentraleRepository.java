package com.optimizertruck.crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optimizertruck.crudapi.model.Centrale;

@Repository
public interface CentraleRepository extends JpaRepository<Centrale, Long> {


}
