package br.edu.ufape.reu.service;

import java.util.List;

import br.edu.ufape.reu.model.Departamentos;

public interface DepartamentosServiceInterface {
	Departamentos saveDepartamentos(Departamentos o);
	Departamentos findDepartamentosById(long id);
	Departamentos updateDepartamentos(Departamentos u);
	void deleteDepartamentos(Departamentos u);
	void deleteDepartamentos(long id);
	List<Departamentos> getAllDepartamentos();
    
    

    
}