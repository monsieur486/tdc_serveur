package com.mr486.tdc.serveur.service;

import com.mr486.tdc.serveur.model.Copain;
import com.mr486.tdc.serveur.tools.ResourceNotFoundException;
import com.mr486.tdc.serveur.repository.CopainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class CopainServiceImpl implements CopainService{

  @Autowired
  private CopainRepository copainRepository;

  @Override
  public List<Copain> toutLesCopains() {
    List<Copain> copains = new ArrayList<>();
    copainRepository.findAll(Sort.by(Sort.Direction.ASC,
      "nom")).forEach(copains::add);
    return copains;
  }

  @Override
  public void enregistreCopain(Copain copain) {
    this.copainRepository.save(copain);
  }

  @Override
  public Copain copainParId(long id) throws ResourceNotFoundException {
    Copain copain = copainRepository.findById(id).orElse(null);
    if (copain==null) {
      throw new ResourceNotFoundException("Copain introuvable avec l'id: " + id);
    }
    else return copain;
  }

  @Override
  public void supprimeCopainParId(long id) {
    this.copainRepository.deleteById(id);
  }

  public Long count() {
    return copainRepository.count();
  }
}
