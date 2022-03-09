package com.mr486.tdc.serveur.service;

import com.mr486.tdc.serveur.model.Copain;
import com.mr486.tdc.serveur.tools.ResourceNotFoundException;
import java.util.List;

public interface CopainService {
  Boolean exist(Long id);
  List<Copain> toutLesCopains(int page, int lignes);
  Copain enregistreCopain(Copain copain);
  Copain copainParId(long id) throws ResourceNotFoundException;
  void supprimeCopainParId(long id);
}
