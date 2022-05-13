package com.optimizertruck.crudapi.repository;


import com.optimizertruck.crudapi.model.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.optimizertruck.crudapi.model.Centrale;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface CentraleRepository extends JpaRepository<Centrale, String> {


}
