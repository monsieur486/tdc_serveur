package com.mr486.tdc.serveur.repository;

import com.mr486.tdc.serveur.model.Copain;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopainRepository extends PagingAndSortingRepository<Copain, Long>,
  JpaSpecificationExecutor<Copain> {
}

