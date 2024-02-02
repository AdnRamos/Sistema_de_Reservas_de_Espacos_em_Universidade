package br.edu.ufape.reu.service;

import java.util.List;

import br.edu.ufape.reu.model.Penalidades;

public interface PenalidadesServicesInterface {

  Penalidades savePenalidades(Penalidades o);
  Penalidades findPenalidadesById(long id);
  Penalidades updatePenalidades(Penalidades u);
  void deletePenalidades(Penalidades u);
  void deletePenalidades(long id);
  List<Penalidades> getAllPenalidades();
}
