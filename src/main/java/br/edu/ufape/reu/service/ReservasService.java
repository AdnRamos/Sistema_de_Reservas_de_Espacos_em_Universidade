package br.edu.ufape.reu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.reu.repository.ReservasRepository;
import br.edu.ufape.reu.model.Reservas;

@Service
public class ReservasService implements ReservasServiceInterface {
	@Autowired
	private ReservasRepository repository;


	public Reservas saveReservas(Reservas newInstance) {
		return repository.save(newInstance);
	}

	public Reservas updateReservas(Reservas transientObject) {
		return repository.save(transientObject);
	}

	public Reservas findReservasById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Reservas with id = " + id));
	}

	public List<Reservas> getAllReservas(){
		return repository.findAll();
	}

	public void deleteReservas(Reservas persistentObject){
		this.deleteReservas(persistentObject.getId());
		
	}
	
	public void deleteReservas(long id){
		Reservas obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Reservas with id = " + id));
		repository.delete(obj);
	}	
	
	
	
}