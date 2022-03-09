package com.mr486.tdc.serveur.service;

import com.mr486.tdc.serveur.model.Copain;
import com.mr486.tdc.serveur.tools.ResourceNotFoundException;
import java.util.List;

public interface CopainService {
  Boolean existe(Long id);
  List<Copain> toutLesCopains(int page, int lignes);
  Copain enregistreCopain(Copain copain);
  Copain copainAvecId(long id) throws ResourceNotFoundException;
  void supprimeCopainAvecId(long id);
  long compte();
}
