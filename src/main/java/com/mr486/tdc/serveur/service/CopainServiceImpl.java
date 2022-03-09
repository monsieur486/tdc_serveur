package com.mr486.tdc.serveur.service;

import com.mr486.tdc.serveur.model.Copain;
import com.mr486.tdc.serveur.tools.ResourceNotFoundException;
import com.mr486.tdc.serveur.repository.CopainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class CopainServiceImpl implements CopainService{

  @Autowired
  private CopainRepository copainRepository;

  public Boolean exist(Long id) {
    return copainRepository.existsById(id);
  }

  public Copain copainParId(long id) throws ResourceNotFoundException {
    Copain copain = copainRepository.findById(id).orElse(null);
    if (copain==null) {
      throw new ResourceNotFoundException("Copain introuvable avec l'id: " + id);
    }
    else return copain;
  }

  public List<Copain> toutLesCopains(int page, int lignes) {
    List<Copain> copains = new ArrayList<>();
    Pageable triesParNom = PageRequest.of(page - 1, lignes,
      Sort.by("nom").ascending());
    copainRepository.findAll(triesParNom).forEach(copains::add);
    return copains;
  }

  public Copain enregistreCopain(Copain copain) {

    return copainRepository.save(copain);

  }

  public void supprimeCopainParId(long id) {
    this.copainRepository.deleteById(id);
  }

  public Long count() {
    return copainRepository.count();
  }
}
