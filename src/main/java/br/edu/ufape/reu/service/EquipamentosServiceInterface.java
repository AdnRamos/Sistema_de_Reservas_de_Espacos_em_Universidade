package br.edu.ufape.reu.service;

import java.util.List;

import br.edu.ufape.reu.model.Equipamentos;

public interface EquipamentosServiceInterface {
	Equipamentos saveEquipamentos(Equipamentos o);
	Equipamentos findEquipamentosById(long id);
	Equipamentos updateEquipamentos(Equipamentos u);
	void deleteEquipamentos(Equipamentos u);
	void deleteEquipamentos(long id);
	List<Equipamentos> getAllEquipamentos();
    
    

    
}