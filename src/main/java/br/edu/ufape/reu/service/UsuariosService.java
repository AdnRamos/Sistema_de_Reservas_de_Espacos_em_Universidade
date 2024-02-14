package br.edu.ufape.reu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.reu.model.Usuarios;
import br.edu.ufape.reu.repository.UsuariosRepository;

@Service
public class UsuariosService implements UsuariosServiceInterface {
	@Autowired
	private UsuariosRepository repository;


	@Override
	public Usuarios saveUsuarios(Usuarios newInstance) {
		return repository.save(newInstance);
	}

	@Override
	public Usuarios updateUsuarios(Usuarios transientObject) {
		return repository.save(transientObject);
	}

	@Override
	public Usuarios findUsuariosById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Usuarios with id = " + id));
	}

	@Override
	public List<Usuarios> getAllUsuarios(){
		return repository.findAll();
	}

	@Override
	public void deleteUsuarios(Usuarios persistentObject){
//		this.deleteUsuarios(persistentObject.getId());

	}

	@Override
	public void deleteUsuarios(long id){
		Usuarios obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Usuarios with id = " + id));
		repository.delete(obj);
	}



}