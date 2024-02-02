package br.edu.ufape.reu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.reu.model.Disponibilidade;
import br.edu.ufape.reu.repository.RestricoesHorarioRepository;

@Service
public class RestricoesHorarioService implements RestricoesHorarioServiceInterface {
	@Autowired
	private RestricoesHorarioRepository repository;


	@Override
	public Disponibilidade saveRestricoesHorario(Disponibilidade newInstance) {
		return repository.save(newInstance);
	}

	@Override
	public Disponibilidade updateRestricoesHorario(Disponibilidade transientObject) {
		return repository.save(transientObject);
	}

	@Override
	public Disponibilidade findRestricoesHorarioById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist RestricoesHorario with id = " + id));
	}

	@Override
	public List<Disponibilidade> getAllRestricoesHorario(){
		return repository.findAll();
	}

	@Override
	public void deleteRestricoesHorario(Disponibilidade persistentObject){
		this.deleteRestricoesHorario(persistentObject.getId());

	}

	@Override
	public void deleteRestricoesHorario(long id){
		Disponibilidade obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist RestricoesHorario with id = " + id));
		repository.delete(obj);
	}



}