package br.edu.ufape.reu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.reu.repository.UsuariosRepository;
import br.edu.ufape.reu.model.Usuarios;

@Service
public class UsuariosService implements UsuariosServiceInterface {
	@Autowired
	private UsuariosRepository repository;


	public Usuarios saveUsuarios(Usuarios newInstance) {
		return repository.save(newInstance);
	}

	public Usuarios updateUsuarios(Usuarios transientObject) {
		return repository.save(transientObject);
	}

	public Usuarios findUsuariosById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Usuarios with id = " + id));
	}

	public List<Usuarios> getAllUsuarios(){
		return repository.findAll();
	}

	public void deleteUsuarios(Usuarios persistentObject){
		this.deleteUsuarios(persistentObject.getId());
		
	}
	
	public void deleteUsuarios(long id){
		Usuarios obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Usuarios with id = " + id));
		repository.delete(obj);
	}	
	
	
	
}