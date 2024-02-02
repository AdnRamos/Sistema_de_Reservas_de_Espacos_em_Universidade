package br.edu.ufape.reu.service;

import java.util.List;

import br.edu.ufape.reu.model.Disponibilidade;

public interface RestricoesHorarioServiceInterface {
	Disponibilidade saveRestricoesHorario(Disponibilidade o);
	Disponibilidade findRestricoesHorarioById(long id);
	Disponibilidade updateRestricoesHorario(Disponibilidade u);
	void deleteRestricoesHorario(Disponibilidade u);
	void deleteRestricoesHorario(long id);
	List<Disponibilidade> getAllRestricoesHorario();




}