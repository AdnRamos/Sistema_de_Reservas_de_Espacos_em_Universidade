package br.edu.ufape.reu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.reu.model.Treinamentos;
import br.edu.ufape.reu.repository.TreinamentosRepository;

@Service
public class TreinamentosService implements TreinamentosServiceInterface {
	@Autowired
	private TreinamentosRepository repository;


	@Override
	public Treinamentos saveTreinamentos(Treinamentos newInstance) {
		return repository.save(newInstance);
	}

	@Override
	public Treinamentos updateTreinamentos(Treinamentos transientObject) {
		return repository.save(transientObject);
	}

	@Override
	public Treinamentos findTreinamentosById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Treinamentos with id = " + id));
	}

	@Override
	public List<Treinamentos> getAllTreinamentos(){
		return repository.findAll();
	}

	@Override
	public void deleteTreinamentos(Treinamentos persistentObject){
		this.deleteTreinamentos(persistentObject.getId());

	}

	@Override
	public void deleteTreinamentos(long id){
		Treinamentos obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Treinamentos with id = " + id));
		repository.delete(obj);
	}



}