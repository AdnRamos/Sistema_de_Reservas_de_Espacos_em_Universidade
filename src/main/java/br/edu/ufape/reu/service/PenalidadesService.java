package br.edu.ufape.reu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.reu.model.Penalidades;
import br.edu.ufape.reu.repository.PenalidadesRepository;

@Service
public class PenalidadesService implements PenalidadesServicesInterface{

  @Autowired
  private PenalidadesRepository repository;

  @Override
  public Penalidades savePenalidades(Penalidades newInstance) {
    return repository.save(newInstance);
  }

  @Override
  public Penalidades updatePenalidades(Penalidades transientObject) {
    return repository.save(transientObject);
  }

  @Override
  public Penalidades findPenalidadesById(long id) {
    return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Penalidades with id = " + id));
  }

  @Override
  public List<Penalidades> getAllPenalidades(){
    return repository.findAll();
  }

  @Override
  public void deletePenalidades(Penalidades persistentObject){
    this.deletePenalidades(persistentObject.getId());

  }

  @Override
  public void deletePenalidades(long id){
    Penalidades obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Penalidades with id = " + id));
    repository.delete(obj);
  }
  
  
}
