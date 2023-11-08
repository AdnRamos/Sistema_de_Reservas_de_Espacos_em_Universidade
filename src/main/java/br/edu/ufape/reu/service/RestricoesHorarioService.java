package br.edu.ufape.reu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.reu.model.RestricoesHorario;
import br.edu.ufape.reu.repository.RestricoesHorarioRepository;

@Service
public class RestricoesHorarioService implements RestricoesHorarioServiceInterface {
	@Autowired
	private RestricoesHorarioRepository repository;


	@Override
	public RestricoesHorario saveRestricoesHorario(RestricoesHorario newInstance) {
		return repository.save(newInstance);
	}

	@Override
	public RestricoesHorario updateRestricoesHorario(RestricoesHorario transientObject) {
		return repository.save(transientObject);
	}

	@Override
	public RestricoesHorario findRestricoesHorarioById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist RestricoesHorario with id = " + id));
	}

	@Override
	public List<RestricoesHorario> getAllRestricoesHorario(){
		return repository.findAll();
	}

	@Override
	public void deleteRestricoesHorario(RestricoesHorario persistentObject){
		this.deleteRestricoesHorario(persistentObject.getId());

	}

	@Override
	public void deleteRestricoesHorario(long id){
		RestricoesHorario obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist RestricoesHorario with id = " + id));
		repository.delete(obj);
	}



}