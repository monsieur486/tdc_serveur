package com.mr486.tdc.serveur.service;

import com.mr486.tdc.serveur.model.Cagnotte;
import com.mr486.tdc.serveur.tools.ResourceNotFoundException;
import java.util.List;

public interface CagnotteService {
  Boolean existe(Long id);
  List<Cagnotte> toutesLesCagnottes();
  Cagnotte enregistreCagnotte(Cagnotte cagnotte);
  Cagnotte cagnotteAvecId(long id) throws ResourceNotFoundException;
  void supprimeCagnotteAvecId(long id);
  long compte();
}
