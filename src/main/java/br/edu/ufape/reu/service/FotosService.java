package br.edu.ufape.reu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.reu.model.Fotos;
import br.edu.ufape.reu.repository.FotosRepository;

@Service
public class FotosService implements FotosServiceInterface {

  @Autowired
  private FotosRepository repository;

  @Override
  public java.util.List<Fotos> getAllFotos() {
    return repository.findAll();
  }
  @Override
  public Fotos saveFotos(Fotos newInstance) {
    return repository.save(newInstance);
  }

  @Override
  public Fotos updateFotos(Fotos transientObject) {
    return repository.save(transientObject);
  }
  
  @Override
  public Fotos findFotosById(long id) {
    return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Fotos with id = " + id));
  }

  @Override
  public void deleteFotos(Fotos persistentObject){
    this.deleteFotos(persistentObject.getId());
  }

  @Override
  public void deleteFotos(long id){
    Fotos obj = repository.findById(id).orElseThrow(() -> new RuntimeException("It doesn't exist Fotos with id = " + id));
    repository.delete(obj);
  }



}
