package br.edu.ufape.reu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.reu.repository.TreinamentosRepository;
import br.edu.ufape.reu.model.Treinamentos;

@Service
public class TreinamentosService implements TreinamentosServiceInterface {
	@Autowired
	private TreinamentosRepository repository;


	public Treinamentos saveTreinamentos(Treinamentos newInstance) {
		return repository.save(newInstance);
	}

	public Treinamentos updateTreinamentos(Treinamentos transientObject) {
		return repository.save(transientObject);
	}

	public Treinamentos findTreinamentosById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Treinamentos with id = " + id));
	}

	public List<Treinamentos> getAllTreinamentos(){
		return repository.findAll();
	}

	public void deleteTreinamentos(Treinamentos persistentObject){
		this.deleteTreinamentos(persistentObject.getId());
		
	}
	
	public void deleteTreinamentos(long id){
		Treinamentos obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Treinamentos with id = " + id));
		repository.delete(obj);
	}	
	
	
	
}