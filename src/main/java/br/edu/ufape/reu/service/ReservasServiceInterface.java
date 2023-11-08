package br.edu.ufape.reu.service;

import java.util.List;

import br.edu.ufape.reu.model.Reservas;

public interface ReservasServiceInterface {
	Reservas saveReservas(Reservas o);
	Reservas findReservasById(long id);
	Reservas updateReservas(Reservas u);
	void deleteReservas(Reservas u);
	void deleteReservas(long id);
	List<Reservas> getAllReservas();




}