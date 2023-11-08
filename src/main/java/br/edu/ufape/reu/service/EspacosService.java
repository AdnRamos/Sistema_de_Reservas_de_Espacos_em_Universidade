package br.edu.ufape.reu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.reu.repository.EspacosRepository;
import br.edu.ufape.reu.model.Espacos;

@Service
public class EspacosService implements EspacosServiceInterface {
	@Autowired
	private EspacosRepository repository;


	public Espacos saveEspacos(Espacos newInstance) {
		return repository.save(newInstance);
	}

	public Espacos updateEspacos(Espacos transientObject) {
		return repository.save(transientObject);
	}

	public Espacos findEspacosById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Espacos with id = " + id));
	}

	public List<Espacos> getAllEspacos(){
		return repository.findAll();
	}

	public void deleteEspacos(Espacos persistentObject){
		this.deleteEspacos(persistentObject.getId());
		
	}
	
	public void deleteEspacos(long id){
		Espacos obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Espacos with id = " + id));
		repository.delete(obj);
	}	
	
	
	
}