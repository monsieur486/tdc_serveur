package com.mr486.tdc.serveur.repository;

import com.mr486.tdc.serveur.model.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReunionRepository extends JpaRepository<Reunion, Long>,
  JpaSpecificationExecutor<Reunion> {
}
