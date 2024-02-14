package br.edu.ufape.reu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.reu.model.Reservas;
import br.edu.ufape.reu.repository.ReservasRepository;

@Service
public class ReservasService implements ReservasServiceInterface {
	@Autowired
	private ReservasRepository repository;


	@Override
	public Reservas saveReservas(Reservas newInstance) {
		return repository.save(newInstance);
	}

	@Override
	public Reservas updateReservas(Reservas transientObject) {
		return repository.save(transientObject);
	}

	@Override
	public Reservas findReservasById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Reservas with id = " + id));
	}

	@Override
	public List<Reservas> getAllReservas(){
		return repository.findAll();
	}

	@Override
	public void deleteReservas(Reservas persistentObject){
//		this.deleteReservas(persistentObject.getId());

	}

	@Override
	public void deleteReservas(long id){
		Reservas obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist Reservas with id = " + id));
		repository.delete(obj);
	}



}