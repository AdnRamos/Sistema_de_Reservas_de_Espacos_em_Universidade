package br.edu.ufape.reu.service;

import java.util.List;

import br.edu.ufape.reu.model.Espacos;

public interface EspacosServiceInterface {
	Espacos saveEspacos(Espacos o);
	Espacos findEspacosById(long id);
	Espacos updateEspacos(Espacos u);
	void deleteEspacos(Espacos u);
	void deleteEspacos(long id);
	List<Espacos> getAllEspacos();
    
    

    
}