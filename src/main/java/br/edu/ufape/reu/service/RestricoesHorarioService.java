package br.edu.ufape.reu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.reu.repository.RestricoesHorarioRepository;
import br.edu.ufape.reu.model.RestricoesHorario;

@Service
public class RestricoesHorarioService implements RestricoesHorarioServiceInterface {
	@Autowired
	private RestricoesHorarioRepository repository;


	public RestricoesHorario saveRestricoesHorario(RestricoesHorario newInstance) {
		return repository.save(newInstance);
	}

	public RestricoesHorario updateRestricoesHorario(RestricoesHorario transientObject) {
		return repository.save(transientObject);
	}

	public RestricoesHorario findRestricoesHorarioById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist RestricoesHorario with id = " + id));
	}

	public List<RestricoesHorario> getAllRestricoesHorario(){
		return repository.findAll();
	}

	public void deleteRestricoesHorario(RestricoesHorario persistentObject){
		this.deleteRestricoesHorario(persistentObject.getId());
		
	}
	
	public void deleteRestricoesHorario(long id){
		RestricoesHorario obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist RestricoesHorario with id = " + id));
		repository.delete(obj);
	}	
	
	
	
}