package com.optimizertruck.crudapi.repository;

import com.optimizertruck.crudapi.model.Centrale;
import com.optimizertruck.crudapi.model.Logisticien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LogisticienRepository extends JpaRepository<Logisticien, Integer> {


}
