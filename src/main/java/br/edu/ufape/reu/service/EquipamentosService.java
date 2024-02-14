package br.edu.ufape.reu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.reu.model.Equipamentos;
import br.edu.ufape.reu.repository.EquipamentosRepository;

@Service
public class EquipamentosService implements EquipamentosServiceInterface {
	@Autowired
	private EquipamentosRepository repository;


	@Override
	public Equipamentos saveEquipamentos(Equipamentos newInstance) {
		return repository.save(newInstance);
	}

	@Override
	public Equipamentos updateEquipamentos(Equipamentos transientObject) {
		return repository.save(transientObject);
	}

	@Override
	public Equipamentos findEquipamentosById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Equipamentos with id = " + id));
	}

	@Override
	public List<Equipamentos> getAllEquipamentos(){
		return repository.findAll();
	}

	@Override
	public void deleteEquipamentos(Equipamentos persistentObject){
//		this.deleteEquipamentos(persistentObject.getId());

	}

	@Override
	public void deleteEquipamentos(long id){
		Equipamentos obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Equipamentos with id = " + id));
		repository.delete(obj);
	}



}