package br.edu.ufape.reu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.reu.repository.DepartamentosRepository;
import br.edu.ufape.reu.model.Departamentos;

@Service
public class DepartamentosService implements DepartamentosServiceInterface {
	@Autowired
	private DepartamentosRepository repository;


	public Departamentos saveDepartamentos(Departamentos newInstance) {
		return repository.save(newInstance);
	}

	public Departamentos updateDepartamentos(Departamentos transientObject) {
		return repository.save(transientObject);
	}

	public Departamentos findDepartamentosById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Departamentos with id = " + id));
	}

	public List<Departamentos> getAllDepartamentos(){
		return repository.findAll();
	}

	public void deleteDepartamentos(Departamentos persistentObject){
		this.deleteDepartamentos(persistentObject.getId());
		
	}
	
	public void deleteDepartamentos(long id){
		Departamentos obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Departamentos with id = " + id));
		repository.delete(obj);
	}	
	
	
	
}