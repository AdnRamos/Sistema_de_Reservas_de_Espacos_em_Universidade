package br.edu.ufape.reu.service;

import java.util.List;

import br.edu.ufape.reu.model.Treinamentos;

public interface TreinamentosServiceInterface {
	Treinamentos saveTreinamentos(Treinamentos o);
	Treinamentos findTreinamentosById(long id);
	Treinamentos updateTreinamentos(Treinamentos u);
	void deleteTreinamentos(Treinamentos u);
	void deleteTreinamentos(long id);
	List<Treinamentos> getAllTreinamentos();




}