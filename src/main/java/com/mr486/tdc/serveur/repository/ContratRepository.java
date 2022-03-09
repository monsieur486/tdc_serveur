package com.mr486.tdc.serveur.repository;

import com.mr486.tdc.serveur.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long>,
  JpaSpecificationExecutor<Contrat> {
}
