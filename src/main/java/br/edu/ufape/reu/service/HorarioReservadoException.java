package br.edu.ufape.reu.service;

public class HorarioReservadoException extends Exception{
	public HorarioReservadoException() {
		super("Esse horário já foi reservado por outro usuário.");
	}
}
