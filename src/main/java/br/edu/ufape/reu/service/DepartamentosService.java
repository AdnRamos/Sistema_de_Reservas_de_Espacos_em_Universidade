package br.edu.ufape.reu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.reu.model.Departamentos;
import br.edu.ufape.reu.repository.DepartamentosRepository;

@Service
public class DepartamentosService implements DepartamentosServiceInterface {
	
	@Autowired
	private DepartamentosRepository repository;


	@Override
	public Departamentos saveDepartamentos(Departamentos newInstance) {
		return repository.save(newInstance);
	}

	@Override
	public Departamentos updateDepartamentos(Departamentos transientObject) {
		return repository.save(transientObject);
	}

	@Override
	public Departamentos findDepartamentosById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Departamentos with id = " + id));
	}

	@Override
	public List<Departamentos> getAllDepartamentos(){
		return repository.findAll();
	}

	@Override
	public void deleteDepartamentos(Departamentos persistentObject){
		this.deleteDepartamentos(persistentObject.getId());

	}

	@Override
	public void deleteDepartamentos(long id){
		Departamentos obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Departamentos with id = " + id));
		repository.delete(obj);
	}

}