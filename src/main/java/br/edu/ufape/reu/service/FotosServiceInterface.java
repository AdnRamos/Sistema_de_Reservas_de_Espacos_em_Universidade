package br.edu.ufape.reu.service;

import java.util.List;
import br.edu.ufape.reu.model.Fotos;

public interface FotosServiceInterface {

  List<Fotos> getAllFotos();
  Fotos saveFotos(Fotos o);
  Fotos updateFotos(Fotos u);
  Fotos findFotosById(long id);
  void deleteFotos(Fotos u);
  void deleteFotos(long id);

  
}
