package com.mr486.tdc.serveur.service;

import com.mr486.tdc.serveur.model.Reunion;
import com.mr486.tdc.serveur.tools.ResourceNotFoundException;
import java.util.List;

public interface ReunionService {
  Boolean existe(Long id);
  List<Reunion> toutesLesReunions();
  Reunion enregistreReunion(Reunion reunion);
  Reunion reunionAvecId(long id) throws ResourceNotFoundException;
  void supprimeReunionAvecId(long id);
  long compte();
}
