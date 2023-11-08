package br.edu.ufape.reu.service;

import java.util.List;

import br.edu.ufape.reu.model.RestricoesHorario;

public interface RestricoesHorarioServiceInterface {
	RestricoesHorario saveRestricoesHorario(RestricoesHorario o);
	RestricoesHorario findRestricoesHorarioById(long id);
	RestricoesHorario updateRestricoesHorario(RestricoesHorario u);
	void deleteRestricoesHorario(RestricoesHorario u);
	void deleteRestricoesHorario(long id);
	List<RestricoesHorario> getAllRestricoesHorario();
    
    

    
}