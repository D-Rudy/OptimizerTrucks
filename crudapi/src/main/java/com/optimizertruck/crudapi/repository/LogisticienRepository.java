package com.optimizertruck.crudapi.repository;

import com.optimizertruck.crudapi.model.Centrale;
import com.optimizertruck.crudapi.model.Logisticien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface LogisticienRepository extends JpaRepository<Logisticien, Long> {


/*    @Query("select l from Logisticien l where l.id = ?1")
    public Logisticien findLogisticien(String matricule);*/
}
